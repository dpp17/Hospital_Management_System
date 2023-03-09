package com.bz.hospitalsystem.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bz.hospitalsystem.exceptions.FirstNameNotCorrectException;
import com.bz.hospitalsystem.exceptions.LastNameNotCorrectException;
import com.bz.hospitalsystem.interfaces.IHospital;
import com.bz.hospitalsystem.interfaces.IHospitalRegex;


public class HospitalRegex implements IHospitalRegex{


	public boolean isFirstNameStartWithCapital(String input) {
		boolean result = getValidation(input, EHospitalPatter.NAME_START_WITH_CAPITAL.getConstant()).find();	
		if( !result ) {																																		  			
			throw new FirstNameNotCorrectException("---- Incorrect firstName ----");
		}
		return result;																						
	}
	
	
	public boolean isLastNameStartWithCapital(String input) {
		boolean result = getValidation(input, EHospitalPatter.NAME_START_WITH_CAPITAL.getConstant()).find(); 
		if(!result) {
			throw new LastNameNotCorrectException("---- Incorrect LastName ----");
		}
		return result;
	}
	
	private static Matcher getValidation(String input, String regexPattern) {
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher(input);
		return matcher;
	}
}
