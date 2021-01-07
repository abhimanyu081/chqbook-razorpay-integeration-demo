package com.chqbook.chqbookrazorpayintegerationdemo.repository;

import com.chqbook.chqbookrazorpayintegerationdemo.entity.ChqBookOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChqBookOrderRepository extends JpaRepository<ChqBookOrder,Long> {
}
