/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved.
 */

/*
 * 修订记录：
 * jingling@yiji.com 上午10:55:14 / wjl 创建
 */
package net.admol.baseweb.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * 
 * @author admol
 * 
 */
public class DateUtils {
	/**
	 * 完整时间 yyyy-MM-dd HH:mm:ss
	 */
	public static final String simple = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 年月日 yyyy-MM-dd
	 */
	public static final String dtSimple = "yyyy-MM-dd";
	
	/**
	 * 年月 yyyy-MM
	 */
	public static final String dtSimpleYm = "yyyy-MM";
	
	/**
	 * 获取格式,不允许包含空白字符
	 * 
	 * @param format
	 * @return
	 */
	public static final DateFormat getFormat(String format) {
		if (StringUtils.isBlank(format)) {
			return null;
		}
		DateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat;
	}
	
	/**
	 * 时间转字符串
	 * @param date
	 * @return 返回格式yyyy-MM-dd HH:mm:ss
	 */
	public static final String simpleFormat(Date date) {
		if (date == null) {
			return "";
		}
		return getFormat(simple).format(date);
	}
	
	/**
	 * 
	 * @param date
	 * @return 返回格式:yyyy-MM-dd
	 */
	public static final String dtSimpleFormat(Date date) {
		if (date == null) {
			return "";
		}
		return getFormat(dtSimple).format(date);
	}
	
	/**
	 * 
	 * @param date
	 * @return 返回格式:yyyy-MM
	 */
	public static final String dtSimpleYmFormat(Date date) {
		if (date == null) {
			return "";
		}
		return getFormat(dtSimpleYm).format(date);
	}
	
	/**
	 * 日期格式转换为日期
	 * 
	 * @param strDate yyyy-mm
	 * @return 返回格式:yyyy-mm
	 */
	public static final Date strToDtSimpleYmFormat(String strDate) {
		if (strDate == null) {
			return null;
		}
		try {
			return getFormat(dtSimpleYm).parse(strDate);
		} catch (Exception e) {
		}
		return null;
	}
	
	/**
	 * 日期格式转换为日期
	 * 
	 * @param strDate yyyy-mm-dd
	 * @return 返回格式:yyyy-mm-dd
	 */
	public static final Date strToDtSimpleFormat(String strDate) {
		if (strDate == null) {
			return null;
		}
		try {
			return getFormat(dtSimple).parse(strDate);
		} catch (Exception e) {
		}
		return null;
	}
	
	/**
	 * 返回日期时间
	 * 
	 * @param stringDate yyyy-MM-dd HH:mm:ss
	 * @return 返回时间格式 :yyyy-MM-dd HH:mm:ss
	 * @throws ParseException
	 */
	public static final Date string2DateTime(String stringDate) throws ParseException {
		if (stringDate == null) {
			return null;
		}
		return getFormat(simple).parse(stringDate);
	}
}
