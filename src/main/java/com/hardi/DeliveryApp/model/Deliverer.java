package com.hardi.DeliveryApp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Deliverer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String JMBG;
	
	@Column(nullable = false, unique = true)
	private String IdCardNumber;
	
	@Column(nullable = false)
	private String fullName;
	
	@OneToMany(mappedBy = "deliverer", cascade = CascadeType.ALL)
	private List<Orders> orders = new ArrayList<Orders>();

	public Deliverer() {
	}
	
	public Deliverer(Long id, String jMBG, String IdCardNumber, String fullName, List<Orders> orders) {
		this.id = id;
		this.JMBG = jMBG;
		this.IdCardNumber = IdCardNumber;
		this.fullName = fullName;
		this.orders = orders;
	}

	public Deliverer(String jMBG, String IdCardNumber, String fullName, List<Orders> orders) {
		this.JMBG = jMBG;
		this.IdCardNumber = IdCardNumber;
		this.fullName = fullName;
		this.orders = orders;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJMBG() {
		return JMBG;
	}

	public void setJMBG(String jMBG) {
		JMBG = jMBG;
	}

	public String getIdCardNumber() {
		return IdCardNumber;
	}

	public void setIdCardNumber(String idCardNumber) {
		IdCardNumber = idCardNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
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
		Deliverer other = (Deliverer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Deliverer [id=" + id + ", JMBG=" + JMBG + ", IDCardNumber=" + IdCardNumber + ", fullName=" + fullName
				+ ", orders=" + orders + "]";
	}

	public void deleteOrder(Long id) {
		for(Orders order: this.orders) {
			if(order.getId() == id) {
				this.orders.remove(order);
				return;
			}
		}
		return;
	}
	
}
