package com.hardi.DeliveryApp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hardi.DeliveryApp.model.Bill;
import com.hardi.DeliveryApp.service.BillService;
import com.hardi.DeliveryApp.support.BillToBillDto;
import com.hardi.DeliveryApp.web.dto.BillDTO;

@RestController
@RequestMapping(value = "/api/bills", produces = MediaType.APPLICATION_JSON_VALUE)
public class BillController {

	@Autowired
	private BillService billService;
	
	@Autowired
	private BillToBillDto toDto;
	
	@GetMapping("/{id}")
	public ResponseEntity<BillDTO> getOne(@PathVariable Long id){
		
		Bill bill = billService.getOne(id);
		
		return new ResponseEntity<BillDTO>(toDto.convert(bill), HttpStatus.OK);
	}
}
