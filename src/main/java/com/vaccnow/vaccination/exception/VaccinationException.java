package com.vaccnow.vaccination.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class VaccinationException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String message;
	
	public VaccinationException(){
		
	}
	
	public VaccinationException(String message) {
		super(message);
		this.message = message;
	}

}
