package com.bz.hospitalsystem.utility;

public enum EHospitalPatter {

	NAME_START_WITH_CAPITAL("^[A-Z][a-z]{2,}$");

	String constant;
	
	EHospitalPatter(String constant){
		this.constant=constant;
	}
	public String getConstant() {
		return constant;
	}
}
