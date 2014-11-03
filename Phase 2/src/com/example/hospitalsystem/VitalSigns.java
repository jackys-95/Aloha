package com.example.hospitalsystem;

public class VitalSigns extends Data {
	private int temp;
	private int systolic;
	private int diastolic;
	private int heartRate;
	
	
	public VitalSigns(int temp, int systolic, int diastolic, int heartRate){
		this.temp = temp;
		this.heartRate = heartRate;
		this.systolic = systolic;
		this.diastolic = diastolic;
	}
	
	public String toString() {
		return "Date recorded: " + this.timeRecorded.toString() + "\n" +
				"Temperature: " + Integer.toString(this.temp) + "ÅãC\n" +
				"Heart rate: " + Integer.toString(this.heartRate) + "BPM\n" +
				"Systolic: " + Integer.toString(this.systolic) + "mmHg\n" +
				"Diastolic: " + Integer.toString(this.diastolic) + "mmHg";
	}
	
}
