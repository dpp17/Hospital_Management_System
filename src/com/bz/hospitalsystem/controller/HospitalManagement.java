package com.bz.hospitalsystem.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.bz.hospitalsystem.exceptions.FirstNameNotCorrectException;
import com.bz.hospitalsystem.exceptions.LastNameNotCorrectException;
import com.bz.hospitalsystem.exceptions.PatientAlreadyExistException;
import com.bz.hospitalsystem.exceptions.PatientNotFoundException;
import com.bz.hospitalsystem.interfaces.IHospital;
import com.bz.hospitalsystem.model.HospitalPojo;
import com.bz.hospitalsystem.services.HospitalImplement;

/*
 Program: Write a Java program to create a class called "Hospital" with instance variables "patients" 
 (a list of Patient objects) and "numPatients" (the number of patients in the list). Include the following methods:

    A method to add a patient to the list
    A method to remove a patient from the list
    A method to search for a patient by their ID
    A method to sort the patients in the list by their age (ascending or descending order)
	A method to calculate the average age of all patients
	A method to print the details of all patients in the hospital 
 */

public class HospitalManagement {

	static Scanner userInput = new Scanner(System.in);
	
	
	private static HospitalPojo getDetails() {
		
		HospitalPojo pojo = new HospitalPojo();
		
		System.out.println("Enter FirstName :: ");
		pojo.setFirstName(userInput.next());
		
		System.out.println("Enter LastName :: ");
		pojo.setLastName(userInput.next());
		
		System.out.println("Enter Age :: ");
		pojo.setAge(userInput.nextInt());
		
		return pojo;
	}
	
	public static void main(String[] args) {
		
		IHospital iHospital = new HospitalImplement();
		iHospital.welcomeMessage();
		try {
		do {
		System.out.println(" Press 1: Add Patients " + '\n'+" Press 2: Remove Patient "+'\n'
					+" Press 3: Search By ID "+'\n'+" Press 4: Sort By Age "+'\n'
					+" Press 5: Average Age Of All Patients"+'\n'+" Press 6: Show All Details ");
			try {
				switch (userInput.nextByte()) {
				case 1:
					iHospital.add(getDetails());
					break;
				case 2:
					System.out.println(" Enter Patient firstName:: ");
					iHospital.remove(userInput.next());
					break;
				case 3:
					System.out.println(" Enter Patient Id to search :: ");
					iHospital.searchById(userInput.nextInt());
					break;
				case 4:
					System.out.println(" Press 1: Age in Ascending order" +'\n' +" Press 2: Age in Descending order"+'\n'+" Enter Option :: ");
					iHospital.sortByAge(userInput.nextByte());
					break;
				case 5:
					iHospital.averageAgeOfAllPatients();
					break;
				case 6:
					iHospital.showAllDetails();
					break;
				default:
					break;
				}
			}catch(PatientAlreadyExistException e) {
				System.out.println(e);
			}catch (PatientNotFoundException e) {
				System.out.println(e);
			}catch (FirstNameNotCorrectException e) {
				System.out.println(e);
			}catch (LastNameNotCorrectException e) {
				System.out.println(e);
			}
		System.out.println(" Press 0: To Re-Visit");
		}while(userInput.nextByte() == 0);
		}catch (InputMismatchException e) {
			System.out.println(e);
		}catch (Exception e) {
			System.out.println(e);
		}
		finally {
			iHospital.byeMessage();
		}
	}

}
