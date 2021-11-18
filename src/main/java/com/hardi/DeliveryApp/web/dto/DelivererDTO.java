package com.hardi.DeliveryApp.web.dto;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class DelivererDTO {

	@Positive(message = "Id must be positive.")
	private Long id;
	
	@Size(min = 13, message = "Your unique identifier number must have at least 13 numbers.")
	private String JMBG;
	
	private String IdCardNumber;
	
	private String fullName;
	
	public DelivererDTO() {
		
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
	
}
