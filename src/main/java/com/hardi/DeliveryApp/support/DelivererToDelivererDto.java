package com.hardi.DeliveryApp.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.hardi.DeliveryApp.model.Deliverer;
import com.hardi.DeliveryApp.web.dto.DelivererDTO;

@Component
public class DelivererToDelivererDto implements Converter<Deliverer, DelivererDTO> {

	@Override
	public DelivererDTO convert(Deliverer source) {
		DelivererDTO dto = new DelivererDTO();
		dto.setFullName(source.getFullName());
		dto.setId(source.getId());
		dto.setIdCardNumber(source.getIdCardNumber());
		dto.setJMBG(source.getJMBG());
		
		return dto;
	}
	
	public List<DelivererDTO> convert(List<Deliverer> deliverers){
		List<DelivererDTO> dto = new ArrayList<DelivererDTO>();
		for(Deliverer deliverer : deliverers) {
			dto.add(convert(deliverer));
		}
		return dto;
	}

}
