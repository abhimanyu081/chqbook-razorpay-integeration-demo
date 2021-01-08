package com.chqbook.chqbookrazorpayintegerationdemo.service;

import com.chqbook.chqbookrazorpayintegerationdemo.constants.PaymentStatus;
import com.chqbook.chqbookrazorpayintegerationdemo.dto.RazorPayPaymentDto;
import com.chqbook.chqbookrazorpayintegerationdemo.entity.ChqBookOrder;
import com.chqbook.chqbookrazorpayintegerationdemo.entity.ChqBookOrderPayment;
import com.chqbook.chqbookrazorpayintegerationdemo.repository.ChqBookOrderPaymentRepository;
import com.chqbook.chqbookrazorpayintegerationdemo.service.razorpay.RazorPayPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChqBookOrderPaymentServiceImpl implements ChqBookOrderPaymentService{

    private ChqBookOrderPaymentRepository chqBookOrderPaymentRepository;
    private RazorPayPaymentService razorPayPaymentService;

    @Autowired
    public ChqBookOrderPaymentServiceImpl(ChqBookOrderPaymentRepository chqBookOrderPaymentRepository,
                                          RazorPayPaymentService razorPayPaymentService) {
        this.chqBookOrderPaymentRepository = chqBookOrderPaymentRepository;
        this.razorPayPaymentService=razorPayPaymentService;
    }

    @Override
    public ChqBookOrderPayment create(ChqBookOrderPayment chqBookOrderPayment) {
        return chqBookOrderPaymentRepository.save(chqBookOrderPayment);
    }

    @Override
    public ChqBookOrderPayment findById(Long id) {
        return chqBookOrderPaymentRepository.findById(id).get();
    }


    @Override
    public ChqBookOrderPayment findByRazorPayPaymentId(String razorPayPaymentId) {
        return chqBookOrderPaymentRepository.findByRazorPayPaymentId(razorPayPaymentId);
    }

    @Override
    public ChqBookOrderPayment updateRazorpayPaymentStatus(ChqBookOrder chqBookOrder, String razorpayPaymentId){

        ChqBookOrderPayment chqBookOrderPayment = findByRazorPayPaymentId(razorpayPaymentId);

        //add payment only if it does not already exists
        //this can happen if user has clicked on submit button twice
        //and razorpay did not deduct second attempt
        if(chqBookOrderPayment==null){
            RazorPayPaymentDto razorPayPaymentDto =razorPayPaymentService.fetchPaymentById(razorpayPaymentId);
            chqBookOrderPayment = new ChqBookOrderPayment();
            chqBookOrderPayment.setRazorPayPaymentId(razorPayPaymentDto.getId());
            chqBookOrderPayment.setPaymentStatus(PaymentStatus.valueOf(razorPayPaymentDto.getStatus()));
            chqBookOrderPayment.setAmount(razorPayPaymentDto.getAmount());
            chqBookOrderPayment.setChqBookOrder(chqBookOrder);
            chqBookOrderPayment=create(chqBookOrderPayment);
        }

        return chqBookOrderPayment;
    }


}
