package com.hardi.DeliveryApp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.hardi.DeliveryApp.model.Deliverer;
import com.hardi.DeliveryApp.model.Orders;
import com.hardi.DeliveryApp.repository.OrdersRepository;
import com.hardi.DeliveryApp.service.DelivererService;
import com.hardi.DeliveryApp.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService {
	
	@Autowired
	private OrdersRepository ordersRepository;
	
	@Autowired
	private DelivererService delivererService;

	@Override
	public Page<Orders> getAll(String placeOfDelivery, Long deliveredId, int pageNo) {
		return ordersRepository.search(placeOfDelivery, deliveredId, PageRequest.of(pageNo, 4));
	}

	@Override
	public Orders getOne(Long id) {
		return ordersRepository.findOneById(id);
	}

	@Override
	public Orders save(Orders orders) {
		return ordersRepository.save(orders);
	}

	@Override
	public Orders delete(Long id) {
		Orders orders = ordersRepository.findOneById(id);
		
		if(orders != null) {
			Deliverer deliverer = orders.getDeliverer();
			deliverer.deleteOrder(orders.getId());
			delivererService.update(deliverer);
			
			ordersRepository.delete(orders);
			return orders;
		}
		return null;
	}

}
