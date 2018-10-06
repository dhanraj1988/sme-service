package com.sme.utils;

import java.sql.Timestamp;

public class Utils {
	
	public static Timestamp getCurrentTime(){
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp;
	}
	
	

}
