package com.casestudy.planner.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.casestudy.planner.model.GeneralEnumerationDefinitions.DurationType;

public class PlannerUtils{
	
	public static final int LIGHTNING_DURATION_MINUTES = 5;

	public static int parseDuration(String duration) {
        if (DurationType.LIGHTNING.toString().equalsIgnoreCase(duration)) {
            return LIGHTNING_DURATION_MINUTES;
        } else {
            Matcher matcher = Pattern.compile("(\\d+)min").matcher(duration);
            if (matcher.find()) {
            	int parsedDuration = Integer.parseInt(matcher.group(1).trim());
                if (parsedDuration < 0) {
                    throw new IllegalArgumentException("Invalid duration format: " + duration);
                }
                return parsedDuration;
            } else {
                throw new IllegalArgumentException("Invalid duration format: " + duration);
            }
        }
	}

    
	public static String formatTime(LocalDateTime dateTime) {
	    if (dateTime == null) {
	        throw new NullPointerException("DateTime cannot be null");
	    }
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mma", Locale.ENGLISH); 
	    return dateTime.format(formatter);
	}
}
