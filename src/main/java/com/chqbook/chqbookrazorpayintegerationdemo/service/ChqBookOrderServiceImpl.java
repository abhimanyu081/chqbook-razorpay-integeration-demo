package com.chqbook.chqbookrazorpayintegerationdemo.service;

import com.chqbook.chqbookrazorpayintegerationdemo.constants.Currency;
import com.chqbook.chqbookrazorpayintegerationdemo.constants.OrderStatus;
import com.chqbook.chqbookrazorpayintegerationdemo.constants.PaymentStatus;
import com.chqbook.chqbookrazorpayintegerationdemo.dto.ChqBookOrderDto;
import com.chqbook.chqbookrazorpayintegerationdemo.dto.RazorPayOrderDto;
import com.chqbook.chqbookrazorpayintegerationdemo.entity.ChqBookOrder;
import com.chqbook.chqbookrazorpayintegerationdemo.entity.ChqBookOrderPayment;
import com.chqbook.chqbookrazorpayintegerationdemo.repository.ChqBookOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class ChqBookOrderServiceImpl implements ChqBookOrderService {


    private RazorPayOrderService razorPayOrderService;


    private ChqBookOrderRepository chqBookOrderRepository;


    private ChqBookOrderPaymentService chqBookOrderPaymentService;


    @Autowired
    public ChqBookOrderServiceImpl(RazorPayOrderService razorPayOrderService,
                                   ChqBookOrderRepository chqBookOrderRepository,
                                   ChqBookOrderPaymentService chqBookOrderPaymentService) {
        this.chqBookOrderRepository = chqBookOrderRepository;
        this.razorPayOrderService = razorPayOrderService;
        this.chqBookOrderPaymentService = chqBookOrderPaymentService;
    }

    @Override
    @Transactional
    public ChqBookOrder create(ChqBookOrderDto chqBookOrderDto) {

        //set dummy user for now

        ChqBookOrder chqBookOrder = new ChqBookOrder();

        ChqBookOrderPayment chqBookOrderPayment=new ChqBookOrderPayment();
        chqBookOrderPayment.setChqBookOrder(chqBookOrder);
        chqBookOrderPayment.setPaymentStatus(PaymentStatus.created);
        chqBookOrderPayment.setAmount(chqBookOrderDto.getAmount());
        chqBookOrderPayment=chqBookOrderPaymentService.create(chqBookOrderPayment);

        chqBookOrder.setCreatedAt(LocalDateTime.now());
        chqBookOrder.setChqBookOrderPayment(chqBookOrderPayment);
        chqBookOrder.setUser("dummy user");
        chqBookOrderRepository.save(chqBookOrder);

        RazorPayOrderDto razorPayOrderDto = buildCreateOrderRequest(chqBookOrder);

        razorPayOrderDto = razorPayOrderService.create(razorPayOrderDto);

        chqBookOrder.setRazorPayOrderId(razorPayOrderDto.getId());
        chqBookOrder.getChqBookOrderPayment().setPaymentStatus(razorPayOrderDto.getPaymentStatus());

        return chqBookOrder;


    }

    @Override
    public ChqBookOrder findById(Long id) {
        return chqBookOrderRepository.findById(id).get();
    }

    public RazorPayOrderDto buildCreateOrderRequest(ChqBookOrder chqBookOrder) {
        RazorPayOrderDto razorPayOrderDto = new RazorPayOrderDto();

        razorPayOrderDto.setAmount(chqBookOrder.getChqBookOrderPayment().getAmount());

        razorPayOrderDto.setCurrency(Currency.INR);


        return razorPayOrderDto;
    }


}
