package com.hardi.DeliveryApp.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.hardi.DeliveryApp.model.Orders;
import com.hardi.DeliveryApp.service.BillService;
import com.hardi.DeliveryApp.service.DelivererService;
import com.hardi.DeliveryApp.service.OrdersService;
import com.hardi.DeliveryApp.web.dto.OrdersDTO;

@Component
public class OrdersDtoToOrders implements Converter<OrdersDTO, Orders> {
	
	@Autowired
	private OrdersService ordersService;
	
	@Autowired
	private DelivererService delivererService;
	
	@Autowired
	private BillService billService;

	@Override
	public Orders convert(OrdersDTO dto) {
		Orders entity;
		
		if(dto.getId() == null) {
			entity = new Orders();
		} else {
			entity = ordersService.getOne(dto.getId());
		}
		
		if(entity != null) {
			entity.setDate(dto.getDate());
			entity.setDeliverer(delivererService.getOne(dto.getDeliveryId()));
			entity.setDescription(dto.getDescription());
			entity.setOrderNumber(dto.getOrderNumber());
			entity.setPlaceOfDelivery(dto.getPlaceOfDelivery());
			entity.setPrice(dto.getPrice());
			
			if(dto.getBillId() != null) {
				entity.setBill(billService.getOne(dto.getBillId()));
			}	
			
			return entity;
		}
		return null;
	}

}
