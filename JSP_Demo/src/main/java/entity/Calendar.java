package entity;

import java.time.*;

public class Calendar {
	LocalDate localDate = LocalDate.now();
	public int year = localDate.getYear();
	public int month = localDate.getMonthValue();
	public int day = localDate.getDayOfMonth();
	public String getDate() {
		String date = String.valueOf(day) + "-" + String.valueOf(month) + "-" + String.valueOf(year);
		return date;
	}
}
