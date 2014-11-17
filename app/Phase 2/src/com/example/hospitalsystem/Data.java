package com.example.hospitalsystem;

import java.io.Serializable;

public abstract class Data implements Serializable{
	
	/** This Data object's serialization UID */
	private static final long serialVersionUID = 1106936550303749492L;
	
	/** The Time that this Data was recorded */
	Time timeRecorded;
	
}
