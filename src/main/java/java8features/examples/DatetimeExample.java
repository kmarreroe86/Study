package java8features.examples;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DatetimeExample {

	public static void main(String[] args) {
		
		LocalDateTime currentTime = LocalDateTime.now();
		System.out.println("Now: " + currentTime);
		LocalDateTime tomorrow = currentTime.plusDays(1);
		
		String formatedDate = tomorrow.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		System.out.println(formatedDate);
		System.out.println("Year: " + tomorrow.getYear());
		
		System.out.println("--- Date Zone ---");
		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println("Time zone: " + zdt);
		
		ZonedDateTime zdt2 = ZonedDateTime.now(ZoneId.of(ZoneId.SHORT_IDS.get("PST")));
		System.out.println("Time zone (PST): " + zdt2);
		
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime);		

	}

}
