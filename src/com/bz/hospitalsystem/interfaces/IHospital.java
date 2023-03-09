package com.bz.hospitalsystem.interfaces;

import com.bz.hospitalsystem.model.HospitalPojo;

public interface IHospital {

	void welcomeMessage();
	void byeMessage();
	void add(HospitalPojo patient);
	void remove(String patient);
	void searchById(int patientId);
	void sortByAge(byte option);
	void averageAgeOfAllPatients();
	void showAllDetails();
}
