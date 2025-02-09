package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {
	
	public static String getCurrentDateTime() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(new Date());
	}

	public static String getDateTime() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return sdf.format(new Date());
	}
	
	public static String getCurrentDate() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		return sdf.format(new Date());
	}
	
	public static String getCurrentTime() {
		SimpleDateFormat sdf=new SimpleDateFormat("HHmmss");
		return sdf.format(new Date());
	}
	
	public static String getTime() {
		SimpleDateFormat sdf=new SimpleDateFormat("HHmmssSSS");
		return sdf.format(new Date());
	}
	
	public static String formatedTime(String format) {
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		return sdf.format(new Date());
	}
	
	public static String addDaysByFormatter(int days,String dateFormat) {
		Calendar cal=Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, days);
		SimpleDateFormat formatter=new SimpleDateFormat(dateFormat);
		return formatter.format(cal.getTime());
	}
	
	public static String addMonthsByFormatter(int months,String dateFormat) {
		Calendar cal=Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MONTH, months);
		SimpleDateFormat formatter=new SimpleDateFormat(dateFormat);
		return formatter.format(cal.getTime());
	}
	
	public static String addYearsByFormatter(int years,String dateFormat) {
		Calendar cal=Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.YEAR, years);
		SimpleDateFormat formatter=new SimpleDateFormat(dateFormat);
		return formatter.format(cal.getTime());
	}
	
	public static String firstDayOfNextMonth(String dateFormat) {
		Calendar cal=Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MONTH, 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		SimpleDateFormat formatter=new SimpleDateFormat(dateFormat);
		return formatter.format(cal.getTime());
	}
	
	public static String firstDayOfMonth(int year,int month,String dateFormat) {
		Calendar cal=Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.YEAR, year);
		cal.add(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		SimpleDateFormat formatter=new SimpleDateFormat(dateFormat);
		return formatter.format(cal.getTime());
	}
	
	public static String firstDayOfMonth(int month,String dateFormat) {
		Calendar cal=Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		SimpleDateFormat formatter=new SimpleDateFormat(dateFormat);
		return formatter.format(cal.getTime());
	}
	
	public static String getMilSecNow() {
		return String.valueOf(System.currentTimeMillis());
	}
	
	
}
