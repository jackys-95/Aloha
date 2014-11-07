package com.example.hospitalsystem;

import java.io.*;
import java.util.*;

public class PatientSystem {

	private List<Patient> patients;

	public PatientSystem() {
		patients = new ArrayList<Patient>();
	}

	
	/**
	 * Allows the app to get the current patients list
	 * @return
	 */
	public List<Patient> getPatientsList() {
		return this.patients;
	}

	/***
	 * Reads a file from a specified directory and saves it in a String
	 * 
	 * @param dir
	 *            directory
	 * @throws FileNotFoundException
	 */
	public String readFile(File dir) throws FileNotFoundException {
		Scanner scanner = new Scanner(new FileInputStream(dir));
		String text_file = "";
		while (scanner.hasNextLine()) {
			text_file += scanner.nextLine() + "\n";
		}
		scanner.close();
		return text_file;
	}
	
	/**
	 * 
	 * @param patient
	 * @return
	 * @throws FileNotFoundException
	 */
	public String readVital(Patient patient) throws FileNotFoundException {
		Scanner scanner = new Scanner(new FileInputStream("/Users/jacky/tester/" + patient.getHealthCardNumber()));
		String text_file = "";
		while (scanner.hasNextLine()) {
			text_file += scanner.nextLine() + "\n";
		}
		return text_file;
	}

	/***
	 * Populates the Patient System with Patient Objects from patient_records.txt
	 * SHOULD BE USED ONLY ONCE WHEN THE SYSTEM IS JUST ACTIVATED
	 * @param dir
	 * @throws FileNotFoundException
	 */
	public void populateSystem(File dir) throws FileNotFoundException {
		Scanner scanner = new Scanner(new FileInputStream(dir));
		String[] record;
		while (scanner.hasNextLine()) {
			record = scanner.nextLine().split(",");
			String healthCard = record[0];
			String name = record[1];
			String[] dob = record[2].split("-");
			Time time = new Time(Integer.parseInt(dob[0]), Integer.parseInt(dob[1]), Integer.parseInt(dob[2]));
			Patient patient = new Patient(name, healthCard, time);
			this.patients.add(patient);
		}  
		scanner.close();
	}


	/**
	 * Populates the Patient Vitals
	 * Should only be ran at the start of the program
	 * @throws IOException 
	 */
	public void populatePatientVitals() throws IOException {
		for (int i = 0; i < this.patients.size(); i++) {
			/*
			 * What we do is that we must check that the file exists or not since these files will be stored persistently in internal memory 
			 * Either that or we figure out a way to run it ONCE and remember that it has run once no matter how many times Triage is activated
			 */
			Patient currentPatient = patients.get(i);
			String path = "/Users/jacky/Tester/" + currentPatient.getHealthCardNumber();
			File file = new File(path);
			if (file.isFile() == false) {
				FileOutputStream stream = new FileOutputStream(file);
				OutputStreamWriter streamwriter = new OutputStreamWriter(stream);
				Writer w = new BufferedWriter(streamwriter);
				w.close();
			}
		}
	}

	/**
	 * 
	 * @param patient
	 * @param vitals
	 */
	public void updatePatientVitals(Patient patient, VitalSigns vitals) {
		patient.addVitalSigns(vitals);
	}
    
	/**
	 * 
	 * @param patient
	 * @throws IOException
	 */
	public void updatePatientVitalsText(Patient patient) throws IOException {
		String path = "/Users/jacky/Tester/" + patient.getHealthCardNumber();
		File file = new File(path);
		FileOutputStream stream = new FileOutputStream(file, false);
		OutputStreamWriter streamwriter = new OutputStreamWriter(stream);
		Writer w = new BufferedWriter(streamwriter);
		String previous = readVital(patient);
		List <Data> vitalsList = patient.getVitalSignsRecord();
		for (int i = 0; i < vitalsList.size(); i++) {
			w.write(vitalsList.get(i).toString());
			w.write("\n----\n"); //delimiter
		}
		w.write(previous);
		w.close();
	}


	/***
	 * Looks up a patient's health record
	 * 
	 * @param dir
	 * @param patient
	 * @return record
	 * @throws FileNotFoundException
	 */
	public Patient findPatientByHealthCard(String healthCardNumber) {
		String returnString = "";
		for (int i = 0; i < this.patients.size(); i++) {
			if (patients.get(i).healthCardNumberEquals(healthCardNumber)) {
				Patient patient = patients.get(i);
				return patient;
			}
		}
		return null;
	}
}
