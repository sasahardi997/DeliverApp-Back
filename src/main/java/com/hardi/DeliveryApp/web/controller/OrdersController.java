package com.hardi.DeliveryApp.web.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hardi.DeliveryApp.model.Bill;
import com.hardi.DeliveryApp.model.Orders;
import com.hardi.DeliveryApp.service.OrdersService;
import com.hardi.DeliveryApp.support.OrdersDtoToOrders;
import com.hardi.DeliveryApp.support.OrdersToOrdersDto;
import com.hardi.DeliveryApp.web.dto.OrdersDTO;

@RestController
@RequestMapping(value = "/api/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrdersController {

	@Autowired
	private OrdersService ordersService;
	
	@Autowired
	private OrdersToOrdersDto toDto;
	
	@Autowired
	private OrdersDtoToOrders toOrders;
	
	@GetMapping
	public ResponseEntity<List<OrdersDTO>> getAll(
			@RequestParam(required = false) Long delivererId,
			@RequestParam(required = false) String placeOfDelivery,
			@RequestParam(value = "pageNo", defaultValue = "0") int pageNo){
		
		Page<Orders> orders = ordersService.getAll(placeOfDelivery, delivererId, pageNo);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Total-Pages", String.valueOf(orders.getTotalPages()));
		
		return new ResponseEntity<List<OrdersDTO>>(toDto.convert(orders.getContent()), headers, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrdersDTO> getOne(@PathVariable Long id){
		
		Orders order = ordersService.getOne(id);
		
		return new ResponseEntity<OrdersDTO>(toDto.convert(order), HttpStatus.OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrdersDTO> create(@Valid @RequestBody OrdersDTO dto){
		
		Orders created = ordersService.save(toOrders.convert(dto));
		
		return new ResponseEntity<OrdersDTO>(toDto.convert(created), HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrdersDTO> update(@PathVariable Long id, @Valid @RequestBody OrdersDTO dto){
		
		if(id != dto.getId()) {
			return new ResponseEntity<OrdersDTO>(HttpStatus.BAD_REQUEST);
		}
		
		Orders orders = ordersService.save(toOrders.convert(dto));
		
		return new ResponseEntity<OrdersDTO>(toDto.convert(orders), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
		Orders order = ordersService.delete(id);
		
		if(order == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PutMapping("/bills/{id}")
	public ResponseEntity<OrdersDTO> updatBill(@PathVariable Long id){
		
		Orders orders = ordersService.getOne(id);
		
		Bill bill = new Bill();
		bill.setBillNumber(orders.getOrderNumber());
		bill.setTotalPrice(orders.getPrice());
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(LocalDate.now().format(formatter));
		bill.setDate(date);
		
		orders.setBill(bill);
		Orders updated = ordersService.save(orders);
		
		return new ResponseEntity<OrdersDTO>(toDto.convert(updated), HttpStatus.OK);
		
	}
	
	
	
	
	
}
