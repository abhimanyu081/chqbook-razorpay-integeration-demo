package com.chqbook.chqbookrazorpayintegerationdemo.service;

import com.chqbook.chqbookrazorpayintegerationdemo.entity.ChqBookOrderPayment;
import com.chqbook.chqbookrazorpayintegerationdemo.repository.ChqBookOrderPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChqBookOrderPaymentServiceImpl implements ChqBookOrderPaymentService{

    private ChqBookOrderPaymentRepository chqBookOrderPaymentRepository;

    @Autowired
    public ChqBookOrderPaymentServiceImpl(ChqBookOrderPaymentRepository chqBookOrderPaymentRepository) {
        this.chqBookOrderPaymentRepository = chqBookOrderPaymentRepository;
    }

    @Override
    public ChqBookOrderPayment create(ChqBookOrderPayment chqBookOrderPayment) {
        return chqBookOrderPaymentRepository.save(chqBookOrderPayment);
    }

    @Override
    public ChqBookOrderPayment findById(Long id) {
        return chqBookOrderPaymentRepository.findById(id).get();
    }
}
