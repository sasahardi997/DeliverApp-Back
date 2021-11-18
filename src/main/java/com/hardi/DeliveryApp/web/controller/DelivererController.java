package com.hardi.DeliveryApp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hardi.DeliveryApp.model.Deliverer;
import com.hardi.DeliveryApp.service.DelivererService;
import com.hardi.DeliveryApp.support.DelivererToDelivererDto;
import com.hardi.DeliveryApp.web.dto.DelivererDTO;

@RestController
@RequestMapping(value = "/api/deliverers", produces = MediaType.APPLICATION_JSON_VALUE)
public class DelivererController {

	@Autowired
	private DelivererService delivererService;
	
	@Autowired
	private DelivererToDelivererDto toDto;
	
	@GetMapping
	public ResponseEntity<List<DelivererDTO>> getAll(){
		
		List<Deliverer> deliverers = delivererService.getAll();
		
		return new ResponseEntity<List<DelivererDTO>>(toDto.convert(deliverers), HttpStatus.OK);
	}
}
