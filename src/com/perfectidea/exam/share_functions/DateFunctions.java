package com.perfectidea.exam.share_functions;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.IllegalFormatException;
import java.util.Locale;

/**
 * 日期格式轉換函式
 * @author leo.chang
 * */
public class DateFunctions {
	/**
	 * Create a Singleton
	 * */
	private static DateFunctions instance = null;
	public static DateFunctions getInstance()
	{
		if (instance == null) {
			synchronized(DateFunctions.class) {
				if (instance == null) {
					instance = new DateFunctions();
				}
			}
		}
		return instance;
	}
	/**
	 * 字串轉民國年
	 * @author leo.chang
	 * @param dateString
	 * @throws NumberFormatException, ParseException
	 * */
	public Date chineseDateToDate(String dateString) throws NumberFormatException, ParseException{
		Date convertDate = null;
		String str = "";
		if (dateString.length() < 9) {
			return new Date();
		}
		int year = Integer.parseInt(dateString.substring(0, 3));
		int mon = Integer.parseInt(dateString.substring(4, 2));
		int day = Integer.parseInt(dateString.substring(7, 2));
		if (year < 1911)
			year += 1911;
		str = String.format(Locale.getDefault(), "%03d/%02d/%02d", year, mon, day);
		convertDate = DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.getDefault()).parse(str);
		return convertDate;
	}
	/**
	 * 日期轉民國年字串
	 * @author leo.chang
	 * @param date:日期
	 * @throws NullPointerException, IllegalFormatException, ArrayIndexOutOfBoundsException
	 * */
	public String dateToChineseDate(Date date) throws NullPointerException, IllegalFormatException,
	ArrayIndexOutOfBoundsException {
		String dateString = "";
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int mon = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DATE);
		if (year > 1911)
			year -= 1911;
		dateString = String.format(Locale.getDefault(),"%03d/%02d/%02d", year, mon, day);
		return dateString;
	}
	/**
	 * 日期轉字串
	 * @author leo.chang
	 * @param date:日期
	 * @throws NullPointerException, IllegalFormatException, ArrayIndexOutOfBoundsException
	 * */
	public String dateToString(Date date) throws NullPointerException, IllegalFormatException,
	ArrayIndexOutOfBoundsException{
		String dateString = "";
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int mon = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DATE);
		if (year < 1911)
			year += 1911;
		dateString = String.format(Locale.getDefault(),"%04d/%02d/%02d", year, mon, day); 
		return dateString;
	}
	/**
	 * 日期轉完成字串+時間
	 * @author leo.chang
	 * @param date
	 * @throws NullPointerException, IllegalFormatException, ArrayIndexOutOfBoundsException
	 * */
	public String dateToFullString(Date date) throws NullPointerException, IllegalFormatException,
	ArrayIndexOutOfBoundsException{
		String dateString = "";
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int mon = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DATE);
		int hour = cal.get(Calendar.HOUR);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		if (year < 1911)
			year += 1911;
		dateString = String.format(Locale.getDefault(),"%04d/%02d/%02d %02d:%02d:%02d", 
				year, mon, day, hour, min, sec); 
		return dateString;
	}
	/**
	 * 取得 時:分
	 * @author leo.chang
	 * @param date:日期
	 * @throws NullPointerException, IllegalFormatException, ArrayIndexOutOfBoundsException
	 * */
	public String getTimeFormatWithDate(Date date) throws NullPointerException, IllegalFormatException,
	ArrayIndexOutOfBoundsException{
		String dateString = "";
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int hour = cal.get(Calendar.HOUR);
		int min = cal.get(Calendar.MINUTE);
		dateString = String.format(Locale.getDefault(),"%02d:%02d", hour, min); 
		return dateString;
	}
	/**
	 * 字串轉日期
	 * @author leo.chang
	 * @param dateString:日期字串
	 * @throws ParseException 
	 * */
	public Date stringToDate(String dateString) throws ParseException {
		Date convertDate = DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.getDefault()).parse(dateString);
		return convertDate;
	}
	/**
	 * 產生民國年月(102/01)
	 * @author leo.chang
	 * @param dateString:日期格式
	 * @throws NullPointerException, IllegalFormatException, NumberFormatException
	 * */
	public String GetYearAndMonthWithDate(String dateString) throws NullPointerException, IllegalFormatException, 
	NumberFormatException{
		String str = "000/00";
		if (dateString.length() < 9) {
			return str;
		}
		int year = Integer.parseInt(dateString.substring(0, 3));
		int mon = Integer.parseInt(dateString.substring(4, 2));
		if (year < 1911)
			year += 1911;
		str = String.format(Locale.getDefault(), "%03d/%02d", year, mon);
		return str;
	}
	/**
	 * 計算兩個日期的天數
	 * @author leo.chang
	 * @param date1, date2
	 * */
	public Integer GetDaysBetweenDates(Date date1, Date date2) {
		int days = (int)( (date1.getTime() - date2.getTime()) / (1000 * 60 * 60 * 24));
		//絕對值
		days = Math.abs(days);
		return days;
	}
	/**
	 * 指出目前是星期幾
	 * @author leo.chang
	 * @param date
	 * @return 0:Sunday ~ 7:Saturday
	 * @throws IllegalFormatException, ArrayIndexOutOfBoundsException
	 * */
	public Integer GetWeekOfDate(Date date) throws IllegalFormatException, ArrayIndexOutOfBoundsException{
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		return dayOfWeek;
	}
	/**
	 * 計算實際年齡
	 * @author leo.chang
	 * @param birth:計算保險年齡
	 * @return realAge:實際年齡
	 * */
	public Integer calculateRealAge(Date birth) {
		int age = 30;	//default age if fail
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(new Date());
		c2.setTime(birth);
		age = c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR);
		int mons = c1.get(Calendar.MONTH) - c2.get(Calendar.MONTH);
		if (mons < 0)
		{
			age --;
		}
		return age;
	}
	/**
	 * 計算保險年齡
	 * @author leo.chang
	 * @param birth:計算保險年齡
	 * @return realAge:實際年齡
	 * */
	public Integer calculateInsuranceAge(Date birth) {
		int age = 30;	//default age if fail
		
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(new Date());
		c2.setTime(birth);
		//保險年齡為提早半年起計算年齡
		c2.add(Calendar.MONTH, -6);
		age = c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR);
		int mons = c1.get(Calendar.MONTH) - c2.get(Calendar.MONTH);
		if (mons < 0)
		{
			age --;
		}
		return age;
	}
	/**
	 * 判斷當年度是否為潤年(西元年)
	 * @author leo.chang
	 * @param year
	 * @return true or false
	 * */
	public boolean checkIsLeapYearOfYear(Integer year) {
		boolean isleap = false;
		if (year < 1911) {
			year += 1911;
		}
		if (year % 400 == 0 || year % 100 == 0 || year % 4 == 0) {
			isleap = true;
		}
		return isleap;
	}
}
