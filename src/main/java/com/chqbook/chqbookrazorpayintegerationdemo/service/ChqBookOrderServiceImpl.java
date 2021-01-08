package com.chqbook.chqbookrazorpayintegerationdemo.service;

import com.chqbook.chqbookrazorpayintegerationdemo.constants.Currency;
import com.chqbook.chqbookrazorpayintegerationdemo.dto.OrderDto;
import com.chqbook.chqbookrazorpayintegerationdemo.entity.ChqBookOrder;
import com.chqbook.chqbookrazorpayintegerationdemo.entity.ChqBookOrderPayment;
import com.chqbook.chqbookrazorpayintegerationdemo.exception.OrderAmountAndPaidAmountMismatched;
import com.chqbook.chqbookrazorpayintegerationdemo.exception.OrderNotFoundException;
import com.chqbook.chqbookrazorpayintegerationdemo.repository.ChqBookOrderRepository;
import com.chqbook.chqbookrazorpayintegerationdemo.service.razorpay.RazorPayOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
@Transactional
public class ChqBookOrderServiceImpl implements ChqBookOrderService {

    private static Logger LOGGER = LoggerFactory.getLogger(ChqBookOrderServiceImpl.class);

    private RazorPayOrderService razorPayOrderService;
    private ChqBookOrderRepository chqBookOrderRepository;
    private ChqBookOrderPaymentService chqBookOrderPaymentService;


    @Autowired
    public ChqBookOrderServiceImpl(RazorPayOrderService razorPayOrderService,
                                   ChqBookOrderRepository chqBookOrderRepository,
                                   ChqBookOrderPaymentService chqBookOrderPaymentService
                                   ) {
        this.chqBookOrderRepository = chqBookOrderRepository;
        this.razorPayOrderService = razorPayOrderService;
        this.chqBookOrderPaymentService = chqBookOrderPaymentService;


    }

    @Override
    public ChqBookOrder create(OrderDto orderDto) {

        //setting some default values into DTO
        if(orderDto.getCurrency()==null){
            orderDto.setCurrency(Currency.INR.name());
        }
        if(orderDto.getPaymentCapture()==null){
            orderDto.setPaymentCapture(1);
        }

        LOGGER.info("Order create Request received. object : {}",orderDto.toString());

        //saving Order in Chqbook DB
        ChqBookOrder chqBookOrder = new ChqBookOrder();
        chqBookOrder.setOrderAmount(orderDto.getAmount());
        chqBookOrder.setOrderDetails(orderDto.getOrderDetails());
        chqBookOrder.setUser("dummy user");
        chqBookOrder.setCreatedAt(LocalDateTime.now());
        chqBookOrder.setTransactionId(orderDto.getTransactionId());
        chqBookOrderRepository.save(chqBookOrder);

        //create order with razorpay, so that razorpay can
        //keep track payments made for an order
        orderDto = razorPayOrderService.create(orderDto);

        LOGGER.info("Setting razorpay id : {}, for order : {}",orderDto.getRazorPayOrderId(),chqBookOrder.getId());

        chqBookOrder.setRazorPayOrderId(orderDto.getRazorPayOrderId());

        return chqBookOrder;


    }

    @Override
    public ChqBookOrder findById(Long id) {
        return chqBookOrderRepository.findById(id).get();
    }

    @Override
    public ChqBookOrder findByRazorPayOrderId(String razorPayOrderId){
        return chqBookOrderRepository.findByRazorPayOrderId(razorPayOrderId);
    }

    @Override
    public ChqBookOrder updatePayment(String razorpayOrderId, String razorpayPaymentId) {

        ChqBookOrder chqBookOrder = findByRazorPayOrderId(razorpayOrderId);

        //this will occur rarely
        if(chqBookOrder==null){
            throw new OrderNotFoundException("The order must be created before updating payment status. razorpay order id : "+razorpayOrderId);
        }

        ChqBookOrderPayment chqBookOrderPayment = chqBookOrderPaymentService.updateRazorpayPaymentStatus(chqBookOrder, razorpayPaymentId);

        chqBookOrder.addPayment(chqBookOrderPayment);

        Integer orderAmount = chqBookOrder.getOrderAmount();
        Integer totalAmountPaid = chqBookOrder.getChqBookOrderPaymentSet().stream().mapToInt(a->a.getAmount()).sum();

        if(orderAmount<totalAmountPaid){

            //assumtion : this will only happen if the order has been paid
            //second time with same amount

            //refund current payment
            //TODO

            throw new OrderAmountAndPaidAmountMismatched("The order amount : "+orderAmount
                    +" and total amount paid for this order does not match. total paid amount : "+totalAmountPaid+
                    " Refunding the difference");
        }

        return chqBookOrder;

    }




}
