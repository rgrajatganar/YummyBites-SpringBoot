package com.ttk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ttk.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
