package com.chqbook.chqbookrazorpayintegerationdemo.repository;

import com.chqbook.chqbookrazorpayintegerationdemo.entity.ChqBookOrderPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChqBookOrderPaymentRepository extends JpaRepository<ChqBookOrderPayment,Long> {
}
