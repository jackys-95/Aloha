package com.example.hospitalsystem;

public class VitalSigns extends Data {
	 
	/** The serialization UID of this VitalSigns object. */
	private static final long serialVersionUID = -3663866084133222844L;
	
	/** The temperature of this VitalSigns object. */
	private float temp;
	
	/** The systolic blood pressure of this VitalSigns object. */
	private int systolic;
	
	/** The diastolic blood pressure of this VitalSigns object. */
	private int diastolic;
	
	/** The heart rate of this VitalSigns object. */
	private int heartRate;
	
	/**
	 * Creates a VitalSigns object with temperature, systolic and diastolic blood pressure.
	 * heart rate, and time that the object was recorded. 
	 * @param temp The temperature.
	 * @param systolic Systolic blood pressure.
	 * @param diastolic Diastolic blood pressure.
	 * @param heartRate Heart rate.
	 * @param timeRecorded Time recorded.
	 */
	public VitalSigns(float temp, int systolic, int diastolic, int heartRate, Time timeRecorded){
		this.timeRecorded = timeRecorded;
		this.temp = temp;
		this.heartRate = heartRate;
		this.systolic = systolic;
		this.diastolic = diastolic;
	}
	
	/**
	 * Returns the Time that this VitalSigns object was recorded.
	 * @return Time that this VitalSigns object was recorded.
	 */
	public Time getTime(){
		return this.timeRecorded;
	}
	
	/**
	 * Returns a String representation of this VitalSigns object.
	 * @return a String representation of this VitalSigns object.
	 */
	public String toString() {
		return "Date recorded: " + this.timeRecorded.toString() + "\n" +
				"Temperature: " + Float.toString(this.temp) + "'C\n" +
				"Heart rate: " + Integer.toString(this.heartRate) + "BPM\n" +
				"Systolic: " + Integer.toString(this.systolic) + "mmHg\n" +
				"Diastolic: " + Integer.toString(this.diastolic) + "mmHg";
	}
	
}
