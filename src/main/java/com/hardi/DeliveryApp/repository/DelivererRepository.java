package com.hardi.DeliveryApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hardi.DeliveryApp.model.Deliverer;

@Repository
public interface DelivererRepository extends JpaRepository<Deliverer, Long> {

	Deliverer findOneById(Long id);
	
}
