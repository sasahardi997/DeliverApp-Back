package com.hardi.DeliveryApp.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private Integer billNumber;
	
	@Column(nullable = false)
	private LocalDate date;
	
	@Column(nullable = false)
	private Double totalPrice;
	
	@OneToOne(mappedBy = "bill")
	private Orders order;

	public Bill() {
	}

	public Bill(Integer billNumber, LocalDate date, Double totalPrice, Orders order) {
		this.billNumber = billNumber;
		this.date = date;
		this.totalPrice = totalPrice;
		this.order = order;
	}

	public Bill(Long id, Integer billNumber, LocalDate date, Double totalPrice, Orders order) {
		this.id = id;
		this.billNumber = billNumber;
		this.date = date;
		this.totalPrice = totalPrice;
		this.order = order;
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bill other = (Bill) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", billNumber=" + billNumber + ", date=" + date + ", totalPrice=" + totalPrice
				+ ", order=" + order + "]";
	}
	
}
