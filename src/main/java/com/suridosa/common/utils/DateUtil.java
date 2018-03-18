package com.suridosa.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.TimeZone;

/**
* ��¥�� ���õ� �޽�带 �����Ѵ�
*/

public final class DateUtil
{
	public final static int SUNDAY = 1;
	public final static int MONDAY = 2;
	public final static int TUESDAY = 3;
	public final static int WEDNESDAY = 4;
	public final static int THURSDAY = 5;
	public final static int FRIDAY = 6;
	public final static int SATURDAY = 7;
	
	static String year		= "";
	static String month		= "";
	static String day		= "";
	static String today		= "";
	static String todayNnow	= "";
	static String subStr	= "/";
	static String subTimeStr= ":";


	/**
	 * ����ð��� long��(milliseconds)���� ��ȯ�Ѵ�.
	 * 
	 * @return long
	 */
	public static long getNow()
	{
		return new Date().getTime();
	}

	/**
	 * 
	 * @param startTime
	 * @param endTime
	 * @return long
	 */
	public static long getInterval(long startTime, long endTime)
	{
		return endTime - startTime;
	}

	/**
	* �־��� ��¥�� yyyyMMddHHmmss �������� ������ <BR>
	*
	* @param date Date ��ü
	* @return yyyyMMddHHmmss ������ 14�ڸ� ��¥
	*/

	public static String getDate(Date date)
	{
		SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyyMMddHHmmss");
		return simpledateformat.format(date);
	}

	/**
	* �־��� ��¥�� yyyyMMdd �������� ������ <BR>
	*
	* @param date Date ��ü
	* @return yyyyMMdd ������ 8�ڸ� ��¥
	*/

	public static String getShortDate(Date date)
	{
		SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyyMMdd");
		return simpledateformat.format(date);
	}

	/**
	* yyyyMMdd ������ ��¥���ڿ��� ���ϴ� ĳ����(ch)�� �ɰ� �����ش� <br>
	* <pre>
	*     ex) 20030405, ch(.) -> 2003.04.05
	*     ex) 200304, ch(.) -> 2003.04
	* </pre>
	*
	* @param date yyyyMMdd ������ ��¥���ڿ�
	* @param ch ������
	* @return ��ȯ�� ���ڿ�
	*/

	public static String formatDate(String date, String ch)
	{
		if (date == null || date.trim().length() == 0)
			return "";

		String str = date.trim();
		String yyyy = "";
		String mm = "";
		String dd = "";

		if (str.length() == 8)
		{
			yyyy = str.substring(0, 4);
			if (yyyy.equals("0000"))
				return "";

			mm = str.substring(4, 6);
			if (mm.equals("00"))
				return yyyy;

			dd = str.substring(6, 8);
			if (dd.equals("00"))
				return yyyy + ch + mm;

			return yyyy + ch + mm + ch + dd;
		}
		else if (str.length() == 6)
		{
			yyyy = str.substring(0, 4);
			if (yyyy.equals("0000"))
				return "";

			mm = str.substring(4, 6);
			if (mm.equals("00"))
				return yyyy;

			return yyyy + ch + mm;
		}
		else if (str.length() == 4)
		{
			yyyy = str.substring(0, 4);
			if (yyyy.equals("0000"))
				return "";
			else
				return yyyy;
		}
		else
			return "";
	}

	/**
	* yyyyMMdd ������ ��¥���ڿ��� KR Format���� �����ش� <br>
	* <pre>
	*     ex) 20030405 -> 2003�� 4�� 5��
	* </pre>
	*
	* @param date yyyyMMdd ������ ��¥���ڿ�
	* @return ��ȯ�� ���ڿ�
	*/

	public static String formatDateKR(String date)
	{
		if (date == null || date.trim().length() == 0 || date.trim().length() != 8)
			return "";

		String str = date.trim();
		String yyyy = "";
		String mm = "";
		String dd = "";

		yyyy = str.substring(0, 4);
		mm = str.substring(4, 6);
		dd = str.substring(6);

		mm = mm.startsWith("0") ? (" " + mm.substring(1)) : mm;
		dd = dd.startsWith("0") ? (" " + dd.substring(1)) : dd;

		return yyyy + "�� " + mm + "�� " + dd + "��";
	}

	/**
	* HH24MISS ������ �ð����ڿ��� ���ϴ� ĳ����(ch)�� �ɰ� �����ش� <br>
	* <pre>
	*     ex) 151241, ch(/) -> 15/12/31
	* </pre>
	*
	* @param str HH24MISS ������ �ð����ڿ�
	* @param ch ������
	* @return ��ȯ�� ���ڿ�
	*/

	public static String formatTime(String str, String ch)
	{
		if (str == null || str.length() == 0)
			return "";
		if (str.length() == 6)
		{
			return str.substring(0, 2) + ch + str.substring(2, 4) + ch + str.substring(4, 6);
		}
		else
			return "";
	}

	/**
	* �־��� ��¥�� ���� ���� ������/�Ͽ��� ��¥�� ���� ��Ʈ���迭�� �����Ѵ� <br>
	*
	* @param str yyyymmdd ������ ��¥���ڿ�
	* @param week �־�����¥�� ���� �ֿ����� ����, 1 : ������, -1 : ����
	* @return ��/�Ͽ���
	* @exception ParseException ���ڿ��Ľ̽� �߻�
	*/

	public static String[] getBothDayOfWeek(String str, int week) throws ParseException
	{
		return new String[] { getFirstDayOfWeek(str, week), getLastDayOfWeek(str, week)};
	}

	/**
	* �־��� ��¥�� ���� ���� ������/�Ͽ��� ��¥�� ���� ��Ʈ���迭�� �����Ѵ� <br>
	*
	* @param date Date��ü
	* @param week �־�����¥�� ���� �ֿ����� ����, 1 : ������, -1 : ����
	* @return ��/�Ͽ���
	* @exception ParseException ���ڿ��Ľ̽� �߻�
	*/

	public static String[] getBothDayOfWeek(Date date, int week) throws ParseException
	{
		return new String[] { getFirstDayOfWeek(date, week), getLastDayOfWeek(date, week)};
	}

	/**
	* �־��� ��¥�� ���� ���� ������ ��¥�� ���Ѵ� <br>
	*
	* @param str yyyymmdd ������ ��¥���ڿ�
	* @param week �־�����¥�� ���� �ֿ����� ����, 1 : ������, -1 : ����
	* @return ������
	* @exception ParseException ���ڿ��Ľ̽� �߻�
	*/

	public static String getFirstDayOfWeek(String str, int week) throws ParseException
	{
		String conStr = null;
		int dayOfWeek = 0;

		if (week == 0)
		{
			conStr = str;
			dayOfWeek = getCalendar(conStr).get(Calendar.DAY_OF_WEEK);
		}
		else
		{
			conStr = addDays(str, week * 7);
			dayOfWeek = getCalendar(conStr).get(Calendar.DAY_OF_WEEK);
		}

		int gap = 0;
		if (dayOfWeek != 1)
			gap = dayOfWeek - 2;
		else
			gap = 6;

		return addDays(conStr, -gap);
	}

	/**
	* �־��� ��¥�� ���� ���� ������ ��¥�� ���Ѵ� <br>
	*
	* @param date Date��ü
	* @param week �־�����¥�� ���� �ֿ����� ����, 1 : ������, -1 : ����
	* @return ������
	* @exception ParseException ���ڿ��Ľ̽� �߻�
	*/

	public static String getFirstDayOfWeek(Date date, int week) throws ParseException
	{
		Date conDate = null;
		int dayOfWeek = 0;

		if (week == 0)
		{
			conDate = date;
			dayOfWeek = getCalendar(conDate).get(Calendar.DAY_OF_WEEK);
		}
		else
		{
			conDate = addDays2Date(date, week * 7);
			dayOfWeek = getCalendar(conDate).get(Calendar.DAY_OF_WEEK);
		}

		int gap = 0;
		if (dayOfWeek != 1)
			gap = dayOfWeek - 2;
		else
			gap = 6;

		return addDays(conDate, -gap);
	}

	/**
	* �־��� ��¥�� ���� ���� �Ͽ��� ��¥�� ���Ѵ� <br>
	*
	* @param str yyyymmdd ������ ��¥���ڿ�
	* @param week �־�����¥�� ���� �ֿ����� ����, 1 : ������, -1 : ����
	* @return ������
	* @exception ParseException ���ڿ��Ľ̽� �߻�
	*/

	public static String getLastDayOfWeek(String str, int week) throws ParseException
	{
		String conStr = null;
		int dayOfWeek = 0;

		if (week == 0)
		{
			conStr = str;
			dayOfWeek = getCalendar(conStr).get(Calendar.DAY_OF_WEEK);
		}
		else
		{
			conStr = addDays(str, week * 7);
			dayOfWeek = getCalendar(conStr).get(Calendar.DAY_OF_WEEK);
		}

		int gap = 0;
		if (dayOfWeek != 1)
			gap = 8 - dayOfWeek;
		else
			gap = 0;

		return addDays(conStr, gap);
	}

	/**
	* �־��� ��¥�� ���� ���� �Ͽ��� ��¥�� ���Ѵ� <br>
	*
	* @param date Date��ü
	* @param week �־�����¥�� ���� �ֿ����� ����, 1 : ������, -1 : ����
	* @return ������
	* @exception ParseException ���ڿ��Ľ̽� �߻�
	*/

	public static String getLastDayOfWeek(Date date, int week) throws ParseException
	{
		Date conDate = null;
		int dayOfWeek = 0;

		if (week == 0)
		{
			conDate = date;
			dayOfWeek = getCalendar(conDate).get(Calendar.DAY_OF_WEEK);
		}
		else
		{
			conDate = addDays2Date(date, week * 7);
			dayOfWeek = getCalendar(conDate).get(Calendar.DAY_OF_WEEK);
		}

		int gap = 0;
		if (dayOfWeek != 1)
			gap = 8 - dayOfWeek;
		else
			gap = 0;

		return addDays(conDate, gap);
	}

	/**
	* �־��� ��¥�� ���� �ְ� ���� ��°�������� ���Ѵ� <br>
	*
	* @param str yyyymmdd ������ ��¥���ڿ�
	* @return ��°��
	*/

	public static int getWeek(String str)
	{
		return getCalendar(str).get(Calendar.WEEK_OF_MONTH);
	}

	/**
	* �־��� ��¥�� ���� �ְ� ���� ��°�������� ���Ѵ� <br>
	*
	* @param date Date��ü
	* @return ��°��
	*/

	public static int getWeek(Date date)
	{
		return getCalendar(date).get(Calendar.WEEK_OF_MONTH);
	}

	/**
	* �־��� ���ڿ��� ��¥������ calendar class ���ϱ� <br>
	*
	* @param str yyyymmdd ������ ��¥���ڿ�
	* @return Calendar-�ν��Ͻ�
	*/

	public static Calendar getCalendar(String str)
	{
		int yy = Integer.parseInt(str.substring(0, 4));
		int mm = Integer.parseInt(str.substring(4, 6)) - 1;
		int dd = Integer.parseInt(str.substring(6, 8));

		Calendar cal = Calendar.getInstance();
		cal.set(yy, mm, dd);
		return cal;
	}

	/**
	* �־��� ���ڿ��� ��¥������ calendar class ���ϱ� <br>
	*
	* @param date Date��ü
	* @return Calendar-�ν��Ͻ�
	*/

	public static Calendar getCalendar(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	/**
	* ��¥���ڿ�(yyyymmdd)�� ��¥�� ����(Ȥ�� ��) ���ڸ� ���� <br>
	*
	* @param str yyyyMMdd ������ ��¥���ڿ�
	* @param days ����, Ȥ�� �� ����
	* @return yyyyyMMdd ������ 8�ڸ� ��¥
	* @exception ��¥���ڿ� ������ �߸��Ǿ��� ��� ParseException return
	*/

	public static String addDays(String str, int days) throws ParseException
	{
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
		Date date = fmt.parse(str);
		date.setTime(date.getTime() + (long) days * 1000L * 60L * 60L * 24L);
		return fmt.format(date);
	}

	/**
	* date�� ��¥�� ����(Ȥ�� ��) ���ڸ� ���� <br>
	*
	* @param date Date��ü
	* @param days ����, Ȥ�� �� ����
	* @return yyyyyMMdd ������ 8�ڸ� ��¥
	* @exception ��¥���ڿ� ������ �߸��Ǿ��� ��� ParseException return
	*/

	public static String addDays(Date date, int days) throws ParseException
	{
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
		date.setTime(date.getTime() + (long) days * 1000L * 60L * 60L * 24L);
		return fmt.format(date);
	}

	/**
	* ��¥���ڿ�(yyyymmdd)�� ��¥�� ����(Ȥ�� ��) ���ڸ� ���� <br>
	*
	* @param str yyyyMMdd ������ ��¥���ڿ�
	* @param days ����, Ȥ�� �� ����
	* @return yyyyyMMdd ������ 8�ڸ� ��¥
	* @exception ��¥���ڿ� ������ �߸��Ǿ��� ��� ParseException return
	*/

	public static Date addDays2Date(String str, int days) throws ParseException
	{
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
		Date date = fmt.parse(str);
		date.setTime(date.getTime() + (long) days * 1000L * 60L * 60L * 24L);
		return date;
	}

	/**
	* ��¥���ڿ�(yyyymmdd)�� ��¥�� ����(Ȥ�� ��) ���ڸ� ���� <br>
	*
	* @param date Date��ü
	* @param days ����, Ȥ�� �� ����
	* @return date
	* @exception ��¥���ڿ� ������ �߸��Ǿ��� ��� ParseException return
	*/

	public static Date addDays2Date(Date date, int days) throws ParseException
	{
		date.setTime(date.getTime() + (long) days * 1000L * 60L * 60L * 24L);
		return date;
	}

	/**
	* �־��� ���ڿ��� �־��� ���ϰ� ��ġ�ϴ��� �ƴ��� ���θ��� <br>
	*
	* @param str yyyyMMdd ������ ��¥���ڿ�
	* @param dayOfWeek ���� (SUNDAY~SATURDAY�� �ϳ�)
	* @return ��¥�� ������ ��ġ�ҽ� true,�ƴϸ� false�� �����Ѵ�
	*/

	public static boolean isDayOfWeek(String str, int dayOfWeek)
	{
		int day = getCalendar(str).get(Calendar.DAY_OF_WEEK);
		if (day == dayOfWeek)
			return true;
		else
			return false;
	}

	/**
	 * �־��� ���ڿ��� �־��� ���ϰ� ��ġ�ϴ��� �ƴ��� ���θ��� <br>
	 *
	 * @param date Date��ü
	 * @param dayOfWeek ���� (SUNDAY~SATURDAY�� �ϳ�)
	 * @return ��¥�� ������ ��ġ�ҽ� true,�ƴϸ� false�� �����Ѵ�
	 */

	public static boolean isDayOfWeek(Date date, int dayOfWeek)
	{
		int day = getCalendar(date).get(Calendar.DAY_OF_WEEK);
		if (day == dayOfWeek)
			return true;
		else
			return false;
	}

	/**
	* �־��� ��¥�� ���� ���� ������ ���� <br>
	*
	* @param str yyyymmdd ������ ��¥
	* @param dayOfWeek ���� (SUNDAY ~ SATURDAY �� �ϳ�)
	* @return yyyyyMMdd ������ 8�ڸ� ��¥
	*/

	public static String getSpecialDayOfWeek(String str, int dayOfWeek) throws ParseException
	{
		int gap = 0;
		int day = getCalendar(str).get(Calendar.DAY_OF_WEEK);

		if (day == dayOfWeek)
			return str;
		else if (dayOfWeek == SUNDAY)
			gap = 8 - day;
		else if (day < dayOfWeek)
			gap = dayOfWeek - day;
		else
			gap = - (day - dayOfWeek);

		if (day == SUNDAY)
			gap = gap - 7;
		return addDays(str, gap);
	}

	/**
	* 14�ڸ� (yyyyMMddHH24MISS) ������ ��¥�� 04/05 (MM/dd) �� �ٲ�
	*
	* @param date yyyyMMddHH24MISS ������ ��¥
	* @param delim ������
	* return MMDD ���Ϲ��ڿ�
	*/

	public static String convertDayOnly(String date, String delim)
	{
		return date.substring(4, 6) + delim + date.substring(6, 8);
	}
	
	  /**
	  * ���� ��/��/���������� �����Ѵ�.
	  *
	  * @return    ���� ����Ͻú���(yyyyMMdd)
	  */
		public static String beforeMonthEndSub()
		{
			dateLoad();
			int imonth = Integer.parseInt(month);
	        imonth = imonth-1;
			month = Integer.toString(imonth);
	        if (month.length() == 1) month = "0"+ month;

			String beforeMonthEndSub	= year + subStr+ month + subStr+ lastDay(Integer.parseInt(year), imonth);

			return beforeMonthEndSub;
		}


		    public static int lastDay(int year, int month){
	        int day = 0;
	        switch(month)
	        {
	            case 1:
	            case 3:
	            case 5:
	            case 7:
	            case 8:
	            case 10:
	            case 12: day = 31;
	                     break;
	            case 2: if ((year % 4) == 0) {
	                        if ((year % 100) == 0 && (year % 400) != 0) { day = 28; }
	                        else { day = 29; }
	                    } else { day = 28; }
	                    break;
	            default: day = 30;
	        }
	        return day;
	    }
		    
	    /**
	     * ���������� ����ð����� �����Ѵ�.
	     */
	   	public static void dateLoad()
	   	{
	   		//���� ��¥ ���
	   		SimpleDateFormat formatter	= new SimpleDateFormat("yyyyMMddHHmmss");
	   		Calendar calendar			= Calendar.getInstance(java.util.Locale.KOREA);  // �ѱ� �������� �ð��� ��������.
	   		Date getTime				= calendar.getTime();
	   		String dateString			= formatter.format(getTime);

	   		year		= dateString.substring(0, 4);
	   		month		= dateString.substring(4, 6);
	   		day			= dateString.substring(6, 8);
	   		today		= dateString.substring(0, 8);
	   		todayNnow	= dateString.substring(0,14);
	   	}		
	   	
	    /**
	     * ����⵵�� �����Ѵ�.
	     *
	     * @return    ����⵵(yyyy)
	     */
	   	public static String year()
	   	{
	   		dateLoad();
	   		return year;
	   	}

	     /**
	     * ������� �����Ѵ�.
	     *
	     * @return    �����(MM)
	     */
	   	public static String month()
	   	{
	   		dateLoad();
	   		return month;
	   	}

	     /**
	     * �������� �����Ѵ�.
	     *
	     * @return    ������(dd)
	     */
	   	public static String day()
	   	{
	   		dateLoad();
	   		return day;
	   	}

	     /**
	     * ���� ������� �����Ѵ�.
	     *
	     * @return    ���� �����(yyyyMMdd)
	     */
	   	public static String today()
	   	{
	   		dateLoad();
	   		return today;
	   	}

	     /**
	     * ���� ����Ͻ��� �����Ѵ�.
	     *
	     * @return    ���� ����Ͻú���(yyyyMMddHHmmss)
	     */
	   	public static String todayNnow()
	   	{
	   		dateLoad();
	   		return todayNnow;
	   	}	   	
	   	
	    /**
	     * yyyyMMdd�� yyyy/MM/dd�� �����Ѵ�.
	     *
	     * @param	   dateStr	�ٲܳ����(yyyyMMdd)
	     * @return    �����(yyyy/MM/dd)
	     */
	   	public static String dateIn(String dateStr)
	   	{
	   		dateLoad();
	   		String dateSub	= "";
	   		if( dateStr != null){
	   			if ( (! dateStr.equals("")) && (dateStr.length() >= 8) )
	   			{
	   				dateSub	= dateStr.substring(0, 4) + subStr
	   						+ dateStr.substring(4, 6) + subStr
	   						+ dateStr.substring(6, 8);
	   			}
	   		}else{
	   			dateSub = "";
	   		}

	   		return dateSub;
	   	}

	     /**
	     * yyyyMMdd�� yyyy.MM.dd�� �����Ѵ�.
	     *
	     * @param	   dateStr	�ٲܳ����(yyyyMMdd)
	     * @return    ��.��.��(yyyy.MM.dd)
	     */
	   	public static String dateInMain(String dateStr)
	   	{
	   		dateLoad();
	   		String dateSub	= "";
	   		if ( (! dateStr.equals("")) && (dateStr.length() >= 8) )
	   		{
	   			dateSub	= dateStr.substring(0, 4) + "."
	   					+ dateStr.substring(4, 6) + "."
	   					+ dateStr.substring(6, 8);
	   		}

	   		return dateSub;
	   	}

	     /**
	     * yyyyMMdd�� yyyy/MM�� �����Ѵ�.
	     *
	     * @param	   dateStr	�ٲܳ����(yyyyMMdd)
	     * @return    ��/��(yyyy/MM)
	     */
	   	public static String dateInMonth(String dateStr)
	   	{
	   		String dateSub	= "";
	   		if ( (! dateStr.equals("")) && (dateStr.length() >= 6) )
	   		{
	   			dateSub	= dateStr.substring(0, 4) + subStr
	   					+ dateStr.substring(4, 6);
	   		}

	   		return dateSub;
	   	}


	     /**
	     * yyyyMMddHHmmss�� yyyy/MM/dd HH:mm:ss�� �����Ѵ�.
	     *
	     * @param	   dateStr	�ٲܳ���Ͻú���(yyyyMMddHHmmss)
	     * @return    ��/��/�� ��:��:��(yyyy/MM/dd HH:mm:ss)
	     */
	   	public static String dateNtimeIn(String dateStr)
	   	{
	   		dateLoad();
	   		String dateSub	= "";
	   		if ( (! dateStr.equals("")) && (dateStr.length() >= 14) )
	   		{
	   			dateSub	= dateStr.substring(0,  4) + subStr
	   					+ dateStr.substring(4,  6) + subStr
	   					+ dateStr.substring(6,  8) + " "
	   					+ dateStr.substring(8, 10) + ":"
	   					+ dateStr.substring(10,12) + ":"
	   					+ dateStr.substring(12,14);
	   		}

	   		return dateSub;
	   	}
	     /**
	     * yyyy/MM/dd HH:mm:ss�� yyyyMMddHHmmss�� �����Ѵ�.
	     *
	     * @param	   dateStr	�ٲ� yyyy/MM/dd HH:mm:ss
	     * @return    yyyyMMddHHmmss
	     */
	   	public static String dateNtimeOut(String dateStr)
	   	{
	   		dateLoad();
	   		String strDateOut	= "";

	   		if ( ! dateStr.equals("") )
	   		{
	   			StringTokenizer strTokenizer	= new StringTokenizer(dateStr, subStr);
	   			StringBuffer	strBuffer		= new StringBuffer();

	   			while(strTokenizer.hasMoreTokens())
	   			{
	   				strBuffer.append(strTokenizer.nextToken().trim());
	   			}
	   			strDateOut	= strBuffer.toString();

	   			strTokenizer	= new StringTokenizer(strDateOut, subTimeStr);
	   			strBuffer		= new StringBuffer();

	   			while(strTokenizer.hasMoreTokens())
	   			{
	   				strBuffer.append(strTokenizer.nextToken().trim());
	   			}
	   			strDateOut	= strBuffer.toString();

	   		}

	   		return strDateOut;
	   	}

	     /**
	     * yyyyMMddHHmm�� yyyy/MM/dd HH:mm�� �����Ѵ�.
	     *
	     * @param	   dateStr	�ٲܳ���Ͻú���(yyyyMMddHHmm)
	     * @return    ��/��/�� ��:��:��(yyyy/MM/dd HH:mm)
	     */
	   	public static String dateNtimeMinIn(String dateStr)
	   	{
	   		dateLoad();
	   		String dateSub	= "";
	   		if ( (! dateStr.equals("")) && (dateStr.length() >= 12) )
	   		{
	   			dateSub	= dateStr.substring(0,  4) + subStr
	   					+ dateStr.substring(4,  6) + subStr
	   					+ dateStr.substring(6,  8) + " "
	   					+ dateStr.substring(8, 10) + ":"
	   					+ dateStr.substring(10,12);
	   		}

	   		return dateSub;
	   	}
	     /**
	     * yyyy/MM/dd HH:mm�� yyyyMMddHHmm�� �����Ѵ�.
	     *
	     * @param	   dateStr	�ٲ� yyyy/MM/dd HH:mm
	     * @return    yyyyMMddHHmmss
	     */
	   	public static String dateNtimeMinOut(String dateStr)
	   	{
	   		dateLoad();
	   		String strDateOut	= "";

	   		if ( ! dateStr.equals("") )
	   		{
	   			StringTokenizer strTokenizer	= new StringTokenizer(dateStr, subStr);
	   			StringBuffer	strBuffer		= new StringBuffer();

	   			while(strTokenizer.hasMoreTokens())
	   			{
	   				strBuffer.append(strTokenizer.nextToken().trim());
	   			}
	   			strDateOut	= strBuffer.toString();

	   			strTokenizer	= new StringTokenizer(strDateOut, subTimeStr);
	   			strBuffer		= new StringBuffer();

	   			while(strTokenizer.hasMoreTokens())
	   			{
	   				strBuffer.append(strTokenizer.nextToken().trim());
	   			}
	   			strDateOut	= strBuffer.toString();

	   		}

	   		return strDateOut;
	   	}

	     /**
	     * HHmmss�� HH:mm:ss�� �����Ѵ�.
	     *
	     * @param	   dateStr	�ٲܽú���(HHmmss)
	     * @return    ��:��:��(HH:mm:ss)
	     */
	   	public static String timeIn(String dateStr)
	   	{
	   		dateLoad();
	   		String dateSub	= "";
	   		if ( (! dateStr.equals("")) && (dateStr.length() >= 6) )
	   		{
	   			dateSub	= dateStr.substring(0,  2) + subTimeStr
	   					+ dateStr.substring(2,  4) + subTimeStr
	   					+ dateStr.substring(4,  6) ;
	   		}

	   		return dateSub;
	   	}

	     /**
	     * HH:mm:ss�� HHmmss�� �����Ѵ�.
	     *
	     * @param	   dateStr	�ٲܽú���(HH:mm:ss)
	     * @return    (HHmmss)
	     */
	   	public static String timeOut(String dateStr)
	   	{
	   		dateLoad();
	   		String strDateOut	= "";

	   		if ( ! dateStr.equals("") )
	   		{
	   			StringTokenizer strTokenizer	= new StringTokenizer(dateStr, subTimeStr);
	   			StringBuffer	strBuffer		= new StringBuffer();

	   			while(strTokenizer.hasMoreTokens())
	   			{
	   				strBuffer.append(strTokenizer.nextToken().trim());
	   			}
	   			strDateOut	= strBuffer.toString();

	   		}

	   		return strDateOut;
	   	}


	     /**
	     * yyyy/MM/dd�� yyyyMMdd�� �����Ѵ�.
	     *
	     * @param	   dateStr	�ٲ� ��/��/��(yyyy/MM/dd)
	     * @return    �����(yyyyMMdd)
	     */
	   	public static String dateOut(String dateStr)
	   	{
	   		dateLoad();
	   		String strDateOut	= "";

	   		if ( ! dateStr.equals("") )
	   		{
	   			StringTokenizer strTokenizer	= new StringTokenizer(dateStr, subStr);
	   			StringBuffer	strBuffer		= new StringBuffer();

	   			while(strTokenizer.hasMoreTokens())
	   			{
	   				strBuffer.append(strTokenizer.nextToken());
	   			}
	   			strDateOut	= strBuffer.toString();
	   		}

	   		return strDateOut;
	   	}


	     /**
	     * yyyy-MM-dd�� yyyyMMdd�� �����Ѵ�.(SAP Data)
	     *
	     * @param	   dateStr	�ٲ� ��-��-��(yyyy-MM-dd)
	     * @return    �����(yyyyMMdd)
	     */
	   	public static String dateOutSap(String dateStr)
	   	{
	   		dateLoad();
	   		String strDateOut	= "";

	   		if ( ! dateStr.equals("") )
	   		{
	   			StringTokenizer strTokenizer	= new StringTokenizer(dateStr, "-");
	   			StringBuffer	strBuffer		= new StringBuffer();

	   			while(strTokenizer.hasMoreTokens())
	   			{
	   				strBuffer.append(strTokenizer.nextToken());
	   			}
	   			strDateOut	= strBuffer.toString();
	   		}

	   		return strDateOut;
	   	}

	     /**
	     * ���� ���(yyyyMMdd)�� X���� ����(yyyyMM)�� �����Ѵ�.
	     *
	     * @param	   monthStr	�ٲ� ���(yyyyMMdd or yyyy/MM/dd)
	     * @param	   iNo		�����
	     * @return    �����(yyyyMMdd)
	     */
	   	public static String minusMonth(String monthStr, int iNo)
	   	{
	   		dateLoad();
	   		String strLastMonth	= "";
	   		monthStr = dateOut(monthStr);

	   		String[] month	= {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
	   		int iYear		= Integer.parseInt(monthStr.substring(0,4));
	   		int iMonth		= Integer.parseInt(monthStr.substring(4,6)) - 1;
	   		String strDay	= monthStr.substring(6,8);
	   		int minusMonth	= iMonth-iNo;

	   		if ( (minusMonth) < 0 )
	   		{
	   			// ���⵵�� �ٲ�
	   			strLastMonth	= Integer.toString(iYear-1) + month[12+minusMonth] + strDay;
	   		}
	   		else
	   		{
	   			strLastMonth	= Integer.toString(iYear) + month[minusMonth] + strDay;
	   		}

	   		return strLastMonth;
	   	}

	    /**
	     * ������ x �� ���� �Ǵ� ������ ���ڸ� �����Ѵ�.
	     * 15�� ����(-15), 20�� ����(20)
	     *
	     * @param	   iDay		������
	     * @return    �����(yyyyMMdd)
	     */
	   	public static String prevNnext(int iDay)
	   	{
	   		SimpleDateFormat formatter	= new SimpleDateFormat("yyyyMMddHHmmss");
	   		Calendar calendar			= Calendar.getInstance(Locale.getDefault());  // �ѱ� �������� �ð��� ��������.
	   		calendar.add(Calendar.DATE,iDay);
	   		Date getTime				= calendar.getTime();
	   		String dateString			= formatter.format(getTime);

	   		return dateString;
	   	}
	     /**
	     * ������ x �� ���� �Ǵ� ������ ���ڸ� �����Ѵ�.
	     * 15�� ����(-15), 20�� ����(20)
	     *
	     * @param	   i		������
	     * @return    �����(yyyyMMdd)
	     */
	       public static String prevNnextSub(int i)
	       {
	           String s = "";
	           SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyyMMddHHmmss");
	           Calendar calendar1 = Calendar.getInstance(Locale.getDefault());
	           calendar1.add(5, i);
	           Date date = calendar1.getTime();
	           s = dateIn(simpledateformat.format(date));
	           return s;
	       }

	     /**
	     * ���� ����Ͻú��ʸ� yyyy��MM��dd��HH��mm��ss�ʷ� �����Ѵ�.
	     *
	     * @param	   dateStr	�ٲ� ����Ͻú���(yyyyMMddHHmmss)
	     * @return    yyyy��MM��dd��HH��mm��ss��
	     */
	   	public static String dateInFinish(String dateStr)
	   	{
	   		dateLoad();
	   		String dateSub	= "";
	   		if ( (! dateStr.equals("")) && (dateStr.length() >= 14) )
	   		{
	   			dateSub	= dateStr.substring(0,  4) + "�� "
	   					+ dateStr.substring(4,  6) + "�� "
	   					+ dateStr.substring(6,  8) + "�� "
	   					+ dateStr.substring(8, 10) + "�� "
	   					+ dateStr.substring(10,12) + "�� "
	   					+ dateStr.substring(12,14) + "��";
	   		}

	   		return dateSub;
	   	}	   	
	   	
		/**
		* ������ �������� ����Ͻú��� �޾ƿ���
		*
		*
		* @param     format         ��¥����
		* @return    String         
		*
		*/
		public static String getTime(String format){
			if ( format == null || format.equals("") == true )
				format = "yyyyMMddHHmmss";
		
			TimeZone tz = TimeZone.getDefault();
			tz.setRawOffset((60*60*1000) * 9);
			TimeZone.setDefault(tz);
			Calendar cal = Calendar.getInstance(tz);
			Date date = cal.getTime();
			SimpleDateFormat formater = new SimpleDateFormat(format, Locale.getDefault());
			String timestamp = formater.format(date);
		
			return timestamp;
		}
		
		/**
		 * COMBO BOX�� ����⵵ +- 5�� ��ȯ<P>
		 *
		 * @param 
		 * @return YYYY ������ 4�ڸ�
		 * @throws Exception
		*/
		public static List list5Year() throws Exception {
			ArrayList rtnValue = new ArrayList();
			
			Date toYear = new Date();
			SimpleDateFormat date = new SimpleDateFormat("yyyy",Locale.KOREA); 
			        	
			int nowYear = Integer.parseInt(date.format(toYear));
			
			for(int i=0; i <= 10; i++) {
				rtnValue.add(i, String.valueOf(nowYear + i - 5));
			}
			
			return rtnValue;
		}
}