package com.hardi.DeliveryApp.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private Integer orderNumber;
	
	@Column(nullable = false)
	private LocalDate date;
	
	@Column(nullable = false)
	private String placeOfDelivery;
	
	@Column
	private Double price;
	
	@Column
	private String description;
	
	@ManyToOne
	private Deliverer deliverer;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Bill bill;

	public Orders() {
	}

	public Orders(Integer orderNumber, LocalDate date, String placeOfDelivery, Double price, String description,
			Deliverer deliverer, Bill bill) {
		this.orderNumber = orderNumber;
		this.date = date;
		this.placeOfDelivery = placeOfDelivery;
		this.price = price;
		this.description = description;
		this.deliverer = deliverer;
		this.bill = bill;
	}

	public Orders(Long id, Integer orderNumber, LocalDate date, String placeOfDelivery, Double price, String description,
			Deliverer deliverer, Bill bill) {
		this.id = id;
		this.orderNumber = orderNumber;
		this.date = date;
		this.placeOfDelivery = placeOfDelivery;
		this.price = price;
		this.description = description;
		this.deliverer = deliverer;
		this.bill = bill;
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

	public Deliverer getDeliverer() {
		return deliverer;
	}

	public void setDeliverer(Deliverer deliverer) {
		this.deliverer = deliverer;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
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
		Orders other = (Orders) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNumber=" + orderNumber + ", date=" + date + ", placeOfDelivery="
				+ placeOfDelivery + ", price=" + price + ", description=" + description + ", deliverer=" + deliverer
				+ ", bill=" + bill + "]";
	}
	
}
