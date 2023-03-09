package com.bz.hospitalsystem.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bz.hospitalsystem.interfaces.IHospital;
import com.bz.hospitalsystem.model.HospitalPojo;
import com.bz.workshopfour.dao.AddPatient;
import com.bz.workshopfour.dao.RemovePatientFromDB;
import com.bz.workshopfour.exceptions.PatientAlreadyExistException;
import com.bz.workshopfour.exceptions.PatientNotFoundException;

public class HospitalImplement implements IHospital{

	static ArrayList<HospitalPojo> patientLog = new ArrayList<HospitalPojo>();
	static AddPatient dbAddition = new AddPatient();
	static RemovePatientFromDB dbRemove = new RemovePatientFromDB();
	
	public void welcomeMessage() {
		System.err.println(" ====================================");
		System.out.println(" :: Welcome To Hospital_Management :: ");
		System.err.println(" ===================================="+'\n');
	} 
	public void byeMessage() {
		System.err.println(" ====================================");
		System.out.println("    :: Thank You For Your Visit ::   ");
		System.err.println(" ===================================="+'\n');
	} 	
	
	
	private void printDetails(HospitalPojo patient) {
		System.out.println("===========================================");
		System.out.println(" Patient ID :: " + patient.getPatientId());
		System.out.println(" FirstName :: " + patient.getFirstName());
		System.out.println(" LastName :: " + patient.getLastName());
		System.out.println(" Age :: " + patient.getAge());
		System.out.println("============================================" + '\n');
	}
	
	public void add(HospitalPojo patient) throws PatientAlreadyExistException{
		patientLog.add(patient);
		patient.setPatientId(patientLog.indexOf(patient));
		dbAddition.addPatint(patient);
		printDetails(patient);
	}

	public void remove(String firstName) throws PatientNotFoundException{
		patientLog.removeIf(data-> data.getFirstName().contains(firstName));
		dbRemove.removePatient(firstName);
	}

	public void searchById(int patientId) {
		patientLog.stream().filter(data->data.getPatientId() == patientId).forEach(data->printDetails(data));
	}

	public void sortByAge(byte option) {
		if(option == 1){
			List<Integer> listAscending =patientLog.stream().map(data->data.getAge()).sorted().collect(Collectors.toList());
			System.out.println(listAscending);
		}else if(option == 2) {
			List<Integer> listDescending =patientLog.stream().map(data->data.getAge()).sorted((a,b)-> a.compareTo(b)).collect(Collectors.toList());
			System.out.println(listDescending);
		}
	}

	public void averageAgeOfAllPatients() {
		long sum = patientLog.stream().mapToInt(HospitalPojo :: getAge).sum();
		long count = patientLog.stream().count();
		System.out.println(" Sum of ages of all patients :: " + sum/count);
	}

	public void showAllDetails() {
		patientLog.stream().forEach(data->printDetails(data));
	}

}
