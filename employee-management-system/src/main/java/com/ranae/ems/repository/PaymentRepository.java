package com.ranae.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ranae.ems.model.Payments;

@Repository
public interface PaymentRepository extends JpaRepository<Payments, Long> {

}
