package com.hardi.DeliveryApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hardi.DeliveryApp.model.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

	Bill findOneById(Long id);
}
