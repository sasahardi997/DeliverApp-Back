package com.hardi.DeliveryApp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hardi.DeliveryApp.model.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

	Orders findOneById(Long id);
	
	@Query("SELECT o FROM Orders o WHERE " + 
			"(:placeOfDelivery = NULL OR o.placeOfDelivery LIKE %:placeOfDelivery%) AND " +
			"(:delivererId = NULL OR o.deliverer.id = :delivererId) ORDER BY o.date")
	Page<Orders> search(
			@Param("placeOfDelivery") String placeOfDelivery,
			@Param("delivererId") Long delivererId,
			Pageable pageable);
}
