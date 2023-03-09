package com.bz.hospitalsystem.exceptions;

public class PatientAlreadyExistException extends RuntimeException {

	public PatientAlreadyExistException(String message) {
		super(message);
	}

}
