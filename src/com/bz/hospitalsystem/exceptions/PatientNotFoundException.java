package com.bz.hospitalsystem.exceptions;

public class PatientNotFoundException extends RuntimeException{

	public PatientNotFoundException(String message) {
		super(message);
	}

}
