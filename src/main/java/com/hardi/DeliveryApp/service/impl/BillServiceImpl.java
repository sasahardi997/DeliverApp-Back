package com.hardi.DeliveryApp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hardi.DeliveryApp.model.Bill;
import com.hardi.DeliveryApp.repository.BillRepository;
import com.hardi.DeliveryApp.service.BillService;

@Service
public class BillServiceImpl implements BillService {
	
	@Autowired
	private BillRepository billRepository;

	@Override
	public List<Bill> getAll() {
		return billRepository.findAll();
	}

	@Override
	public Bill getOne(Long id) {
		return billRepository.findOneById(id);
	}

}
