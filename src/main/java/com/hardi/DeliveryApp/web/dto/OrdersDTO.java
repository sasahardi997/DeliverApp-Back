package com.hardi.DeliveryApp.web.dto;

import java.time.LocalDate;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class OrdersDTO {

	@Positive(message = "Id must be positive.")
	private Long id;
	
	@Positive(message = "Number of order must be positive number.")
	private Integer orderNumber;
	
	private LocalDate date;
	
	@Size(max = 50, message = "Place of delivery can contain maximum 50 characters.")
	private String placeOfDelivery;
	
	private Double price;
	
	private String description;
	
	private Long deliveryId;
	
	private String delivererFullName;
	
	private Long billId;
	
	public OrdersDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getPlaceOfDelivery() {
		return placeOfDelivery;
	}

	public void setPlaceOfDelivery(String placeOfDelivery) {
		this.placeOfDelivery = placeOfDelivery;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}

	public String getDelivererFullName() {
		return delivererFullName;
	}

	public void setDelivererFullName(String delivererFullName) {
		this.delivererFullName = delivererFullName;
	}

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}
	
}
