package com.hardi.DeliveryApp.service;

import java.util.List;

import com.hardi.DeliveryApp.model.Bill;

public interface BillService {

	List<Bill> getAll();
	
	Bill getOne(Long id);
}
