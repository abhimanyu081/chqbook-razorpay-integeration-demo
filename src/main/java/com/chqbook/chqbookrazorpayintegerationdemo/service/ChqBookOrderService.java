package com.chqbook.chqbookrazorpayintegerationdemo.service;

import com.chqbook.chqbookrazorpayintegerationdemo.dto.ChqBookOrderDto;
import com.chqbook.chqbookrazorpayintegerationdemo.entity.ChqBookOrder;

public interface ChqBookOrderService {

    public ChqBookOrder create(ChqBookOrderDto chqBookOrderDto);
    public ChqBookOrder findById(Long id);
}
