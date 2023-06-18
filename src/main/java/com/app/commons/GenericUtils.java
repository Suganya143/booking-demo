package com.app.commons;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Properties;

public class GenericUtils {

	public static Properties AppFileReader(String path) {
		FileReader reader = null;
		try {
			reader = new FileReader(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Properties property = new Properties();
		try {
			property.load(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return property;
	}
	
	public static int getDayByIncrementDaysFromcurrentDate(int incrementDaysBy) {
		 Calendar currentDate = Calendar.getInstance();  
		 currentDate.add(Calendar.DAY_OF_MONTH, incrementDaysBy);
		 return currentDate.get(Calendar.DAY_OF_MONTH);
	}
}
