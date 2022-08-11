package com.learning.seleniummaven;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

import org.testng.annotations.Test;

public class TimeZoneConversion {
	
	public String getCurrentTimeZoneSpecificDateTime(String reqFormat, String timeZone) {
		String str = null;
		try {
			Date now = new Date();
			DateFormat df = new SimpleDateFormat(reqFormat);
			df.setTimeZone(TimeZone.getTimeZone(timeZone));
			str = df.format(now);
		} catch (Exception e) {
			
		}
		return str;
	}
    @Test
	public void getCurrentTime() {
		String CurrentTime = getCurrentTimeZoneSpecificDateTime("DD-MM-YYYY HH:mm", "US/Eastern");
	}

	
}
	


