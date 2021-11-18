package com.hardi.DeliveryApp.service;

import org.springframework.data.domain.Page;

import com.hardi.DeliveryApp.model.Orders;

public interface OrdersService {

	Page<Orders> getAll(String placeOfDelivery, Long deliveredId, int pageNo);
	
	Orders getOne(Long id);
	
	Orders save(Orders orders);
	
	Orders delete(Long id);
}
