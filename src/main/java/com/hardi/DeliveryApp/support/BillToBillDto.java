package com.hardi.DeliveryApp.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.hardi.DeliveryApp.model.Bill;
import com.hardi.DeliveryApp.web.dto.BillDTO;

@Component
public class BillToBillDto implements Converter<Bill, BillDTO> {

	@Override
	public BillDTO convert(Bill source) {
		BillDTO dto = new BillDTO();
		dto.setBillNumber(source.getBillNumber());
		dto.setId(source.getId());
		dto.setTotalPrice(source.getTotalPrice());
		dto.setDate(source.getDate());
		
		return dto;
	}
	
	public List<BillDTO> convert(List<Bill> bills){
		List<BillDTO> dto = new ArrayList<BillDTO>();
		for(Bill bill : bills) {
			dto.add(convert(bill));
		}
		return dto;
	}

}
