package com.example.hospitalsystem;

import java.util.ArrayList;
import java.util.List;

public class Patient {
	private String name;
	private String healthCardNumber;
	private Time dob;
	private Time arrivalTime;
	private List<Data> vitalSignsRecord;
	
	public Patient(String name, String healthCardNumber, Time dob, Time arrivalTime){
		this.name = name;
		this.healthCardNumber = healthCardNumber;
		this.dob = dob;
		vitalSignsRecord = new ArrayList<Data>();
		this.arrivalTime = arrivalTime;
	}
	
	public Patient(String name, String healthCardNumber, Time dob){
		this.name = name;
		this.healthCardNumber = healthCardNumber;
		this.dob = dob;
		vitalSignsRecord = new ArrayList<Data>();
		this.arrivalTime = null;
	}
	
	public void addVitalSigns(VitalSigns v) {
		vitalSignsRecord.add(0, v);
	}
	
	/**
	 * Return if this patient's health card number is number.
	 * @param number The health card number being searched.
	 * @return True if this patient has number as its health card number,
	 * false otherwise.
	 */
	public boolean healthCardNumberEquals(String number) {
		return number.equals(healthCardNumber);
	}
	
	public String getHealthCardNumber() {
		return this.healthCardNumber;
	}
	
	public List<Data> getVitalSignsRecord() {
		return this.vitalSignsRecord;
	}
	
	public String toString() {
		String returnString = "";
		if (arrivalTime == null) {
			returnString = "Name: " + name + "\n" + "Health Card Number: "
					+ healthCardNumber + "\n" + "Birth Date: " + dob.dateString()
					+ "\n";
		}
		else {
		    returnString = "Name: " + name + "\n" + "Health Card Number: "
				+ healthCardNumber + "\n" + "Birth Date: " + dob.dateString()
				+ "\n" + "Time of arrival: " + arrivalTime.toString() + "\n";
		}
		for (int i = 0; i < vitalSignsRecord.size(); i++) {
			returnString += "\n" + vitalSignsRecord.get(i);
		}
		return returnString;
	}
	
}
