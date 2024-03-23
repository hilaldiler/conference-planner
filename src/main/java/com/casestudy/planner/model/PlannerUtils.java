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
                return Integer.parseInt(matcher.group(1).trim());
            } else {
                throw new IllegalArgumentException("Invalid duration format: " + duration);
            }
        }
	}

    
    public static String formatTime(LocalDateTime dateTime) {
    	return dateTime.format(DateTimeFormatter.ofPattern("hh:mma", Locale.ENGLISH));
    }
}
