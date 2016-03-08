/**
 * 
 */
package com.prash.spring.service.util;

import java.util.Date;

import org.joda.time.DateTime;

/**
 * @author Prashanth_Meka
 *
 */
public class CommonUtil {
	
	public static boolean hasXMinutesPassed(Date date, int x)	{
		if(date == null)	{
			return false;
		}
		DateTime paramDate = new DateTime(date);
		return paramDate.plusMinutes(x).isBeforeNow();
	}
	
	public static boolean hasXSecondsPassed(Date date, int x)	{
		if(date == null)	{
			return false;
		}
		DateTime paramDate = new DateTime(date);
		return paramDate.plusSeconds(x).isBeforeNow();
	}
}
