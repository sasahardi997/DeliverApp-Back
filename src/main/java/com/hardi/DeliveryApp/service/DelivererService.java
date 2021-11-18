package com.hardi.DeliveryApp.service;

import java.util.List;

import com.hardi.DeliveryApp.model.Deliverer;

public interface DelivererService {

	List<Deliverer> getAll();
	
	Deliverer getOne(Long id);
	
	Deliverer update(Deliverer deliverer);
}
