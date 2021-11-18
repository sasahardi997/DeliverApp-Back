package com.hardi.DeliveryApp.web.dto;

import java.time.LocalDate;

import javax.validation.constraints.Positive;

public class BillDTO {

	@Positive(message = "Id must be positive.")
	private Long id;
	
	private Integer billNumber;
	
	private Double totalPrice;
	
	private LocalDate date;
	
	public BillDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(Integer billNumber) {
		this.billNumber = billNumber;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}
