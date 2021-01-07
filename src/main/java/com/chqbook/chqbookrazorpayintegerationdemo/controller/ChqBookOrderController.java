package com.chqbook.chqbookrazorpayintegerationdemo.controller;

import com.chqbook.chqbookrazorpayintegerationdemo.constants.PaymentStatus;
import com.chqbook.chqbookrazorpayintegerationdemo.dto.ChqBookOrderDto;
import com.chqbook.chqbookrazorpayintegerationdemo.entity.ChqBookOrder;
import com.chqbook.chqbookrazorpayintegerationdemo.entity.ChqBookOrderPayment;
import com.chqbook.chqbookrazorpayintegerationdemo.service.ChqBookOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class ChqBookOrderController {

    private ChqBookOrderService chqBookOrderService;

    @Autowired
    public ChqBookOrderController(ChqBookOrderService chqBookOrderService) {
        this.chqBookOrderService = chqBookOrderService;
    }

    @PostMapping
    public ChqBookOrder create(@RequestBody ChqBookOrderDto chqBookOrderDto) {
       // throw new RuntimeException("API ERROR");

       return chqBookOrderService.create(chqBookOrderDto);
    }

    @GetMapping("/{id}")
    public ChqBookOrder findById(@PathVariable Long id){
        return chqBookOrderService.findById(id);
    }

}
