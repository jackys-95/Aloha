package com.example.hospitalsystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.List;

public class Patient implements Serializable {

	/** Serialization UID for Patient object. */
	private static final long serialVersionUID = 7106976089219943980L;
	
	/** Name of this Patient. */
	private String name;
	
	/** Health card of this Patient. */
	private String healthCardNumber;
	
	/** Date of birth of this Patient. */
	private Time dob;
	
	/** Arrival time of this Patient. */
	private Time arrivalTime;
	
	/** A list of vital signs for this Patient. */
	private List<VitalSigns> vitalSignsRecord;
	
	/**
	 * Constructs a Patient object with name, date of birth, health card number,
	 * and arrival time.
	 * @param name This Patient's name.
	 * @param healthCardNumber This Patient's health card number.
	 * @param dob This Patient's date of birth.
	 * @param arrivalTime This Patient's arrival time.
	 */
	public Patient(String name, String healthCardNumber, Time dob, Time arrivalTime){
		this.name = name;
		this.healthCardNumber = healthCardNumber;
		this.dob = dob;
		vitalSignsRecord = new ArrayList<VitalSigns>();
		this.arrivalTime = arrivalTime;
	}
	
	/**
	 * Constructs a Patient with just name, health card number, and date of birth.
	 * @param name This Patient's name.
	 * @param healthCardNumber This Patient's health card number.
	 * @param dob This patient's date of birth.
	 */
	public Patient(String name, String healthCardNumber, Time dob){
		this.name = name;
		this.healthCardNumber = healthCardNumber;
		this.dob = dob;
		vitalSignsRecord = new ArrayList<VitalSigns>();
		this.arrivalTime = null;
	}
	
	/**
	 * Adds a VitalSigns object v to this Patient's vitalSignsRecord.
	 * @param v A VitalSigns object.
	 */
	public void addVitalSigns(VitalSigns v) {
		vitalSignsRecord.add(0,v);
	}
	
	/**
	 * Returns this Patient's name.
	 * @return this Patient's name.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Returns this Patient's date of birth.
	 * @return this Patient's date of birth.
	 */
	public String getDob() {
		return this.dob.toString();
	}
	
	/**
	 * Return if this Patient's health card number is number.
	 * @param number The health card number being searched.
	 * @return True if this patient has number as its health card number,
	 * false otherwise.
	 */
	public boolean healthCardNumberEquals(String number) {
		return number.equals(healthCardNumber);
	}
	
	/**
	 * Returns this Patient's health card number.
	 * @return this Patient's health card number.
	 */
	public String getHealthCardNumber() {
		return this.healthCardNumber;
	}
	
	/**
	 * Returns this Patient's vitalSignsRecord.
	 * @return this Patient's vitalSignsRecord.
	 */
	public List<VitalSigns> getVitalSignsRecord() {
		return this.vitalSignsRecord;
	}
	
	public ArrayList<String> getArrayListofRecordsTime(){
		ArrayList<String> records = new ArrayList<String>();
		for (VitalSigns iterator:this.getVitalSignsRecord()){
			records.add(iterator.getTime().toString());
		}
		return records; 
	}
	
	/**
	 * Serializes this Patient object to a given file.
	 * @param dir The file.
	 * @throws FileNotFoundException
	 */
	public void serialize(File dir) throws FileNotFoundException {
		FileOutputStream stream = new FileOutputStream(dir + "/" + healthCardNumber + ".ser");
		try {
		ObjectOutputStream oos = new ObjectOutputStream(stream);
		oos.writeObject(this);
		oos.close();
		}catch(IOException i)
		{
			i.printStackTrace();
		}
		
	}
	
	/**
	 * Deserializes a Patient object given a serialized Patient object from a file.
	 * @param dir The file.
	 * @return Null if file is not found.
	 * @throws FileNotFoundException
	 */
	public Patient deserialize(File dir) throws FileNotFoundException {
			FileInputStream fis = new FileInputStream(dir + "/" + healthCardNumber + ".ser");
			try {
				ObjectInputStream ois = new ObjectInputStream(fis);
				try {
					Patient patient = (Patient) ois.readObject();
					ois.close();
					return patient;
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ois.close();
			} catch (StreamCorruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return null;
	}
	
	/**
	 * Returns a String representation of this Patient object.
	 * @return a String representation of this Patient object.
	 */
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
