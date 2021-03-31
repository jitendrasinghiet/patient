package com.playzone.patient.exception;

public class PatientNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private final String code;
	
	public PatientNotFoundException(String code, String message) {
		super(message);
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	

}
