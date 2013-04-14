package net.plaut.common.util;

import java.util.Date;

public class DateUtil {
	
	public static Date toUtilDate(java.sql.Date date){
		return new Date(date.getTime());
	}
	
	public static java.sql.Date toSqlDate(Date date){
		return new java.sql.Date(date.getTime());
	}
}
