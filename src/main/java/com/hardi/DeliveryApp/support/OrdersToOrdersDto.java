package com.hardi.DeliveryApp.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.hardi.DeliveryApp.model.Orders;
import com.hardi.DeliveryApp.web.dto.OrdersDTO;

@Component
public class OrdersToOrdersDto implements Converter<Orders, OrdersDTO> {

	@Override
	public OrdersDTO convert(Orders source) {
		OrdersDTO dto = new OrdersDTO();
		dto.setDate(source.getDate());
		dto.setDelivererFullName(source.getDeliverer().getFullName());
		dto.setDeliveryId(source.getDeliverer().getId());
		dto.setDescription(source.getDescription());
		dto.setId(source.getId());
		dto.setOrderNumber(source.getOrderNumber());
		
		if(source.getBill() != null) {
			dto.setBillId(source.getBill().getId());
		}
		
		dto.setPlaceOfDelivery(source.getPlaceOfDelivery());
		dto.setPrice(source.getPrice());
		
		return dto;
	}
	
	public List<OrdersDTO> convert(List<Orders> orders){
		List<OrdersDTO> dto = new ArrayList<OrdersDTO>();
		for(Orders order : orders) {
			dto.add(convert(order));
		}
		return dto;
	}

}
