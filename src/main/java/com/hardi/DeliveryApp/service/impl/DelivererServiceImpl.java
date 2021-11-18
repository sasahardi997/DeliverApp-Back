package com.hardi.DeliveryApp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hardi.DeliveryApp.model.Deliverer;
import com.hardi.DeliveryApp.repository.DelivererRepository;
import com.hardi.DeliveryApp.service.DelivererService;

@Service
public class DelivererServiceImpl implements DelivererService {

	@Autowired
	private DelivererRepository delivererRepository;
	
	@Override
	public List<Deliverer> getAll() {
		return delivererRepository.findAll();
	}

	@Override
	public Deliverer getOne(Long id) {
		return delivererRepository.findOneById(id);
	}

	@Override
	public Deliverer update(Deliverer deliverer) {
		return delivererRepository.save(deliverer);
	}

}
