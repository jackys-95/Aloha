package com.example.hospitalsystem;


public class Time implements Comparable<Object>{
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	
	/**
	 * Constructs a Time object 
	 * @param year
	 * @param month
	 * @param day
	 * @param hour
	 * @param minute
	 */
	public Time(int year, int month, int day, int hour, int minute) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
	}


	/**
	 * @return 1 if this time is later than the other time,
	 *  -1 if this time is earlier than the other time,
	 *  0 if both times are the same 
	 */
	@Override
	public int compareTo(Object time) {
		
		int i = compare(((Time)time).year, this.year);
		if (i != 0){
			return i;
		}
		
		i = compare(((Time)time).month, this.month);
		if (i != 0){
			return i;
		}
		
		i = compare(((Time)time).day, this.day);
		if (i != 0){
			return i;
		}
		
		i = compare(((Time)time).hour, this.hour);
		if (i != 0){
			return i;
		}
		
		i = compare(((Time)time).minute, this.minute);
		if (i != 0){
			return i;
		}
		
		return 0;
	}
	
	private int compare(int a, int b){
		if (a > b){
			return -1;
		}
		else if (b < a){
			return 1;
		}
		else {
			return 0;
		}
	}
	
	/**
	 * @return the String representation of this date, in YYYY/MM/DD hh:mm format.
	 */
	public String toString() {
		
		//Formatting of month so that we get 2014/09/09 05:07 instead of 2014/9/9 5:7
		String monthString = Integer.toString(this.month);
		if(this.month < 10){
			monthString = "0" + monthString;
		}
		String dayString = Integer.toString(this.day);
		if(this.month < 10){
			dayString = "0" + monthString;
		}
		String hourString = Integer.toString(this.hour);
		if(this.month < 10){
			hourString = "0" + monthString;
		}
		String minuteString = Integer.toString(this.minute);
		if(this.month < 10){
			minuteString = "0" + monthString;
		}	
		return Integer.toString(this.year) + "/" + monthString + "/" + dayString + " "
				+ hourString + ":" + minuteString;
	}
	
	public String dateString() {
		String monthString = Integer.toString(this.month);
		if(this.month < 10){
			monthString = "0" + monthString;
		}
		String dayString = Integer.toString(this.day);
		if(this.month < 10){
			dayString = "0" + monthString;
		}
		return Integer.toString(this.year) + "/" + monthString + "/" + dayString;
	}
}
 /*appdsa*/