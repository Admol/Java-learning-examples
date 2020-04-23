/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved.
 */

/*
 * 修订记录：
 * jingling@yiji.com 上午11:05:14 / wjl 创建
 */
package net.admol.baseweb.util;

/**
 * 
 * 字符串工具类
 * @author admol
 * 
 */
public class StringUtils {
	/**
	 * 检测字符串是否含有空字符
	 * 
	 * StringUtils.isBlank(null) = true
	 * 
	 * StringUtils.isBlank("") = true
	 * 
	 * StringUtils.isBlank(" ") = true
	 * 
	 * StringUtils.isBlank("bob") = false
	 * 
	 * StringUtils.isBlank("  bob  ") = false
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		int length;
		
		if ((str == null) || ((length = str.length()) == 0)) {
			return true;
		}
		
		for (int i = 0; i < length; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isEmpty(String str) {
		return ((str == null) || (str.length() == 0));
	}
	
	/**
	 * 比较两个字符串（大小写敏感）。
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean equals(String str1, String str2) {
		if (str1 == null) {
			return str2 == null;
		}
		
		return str1.equals(str2);
	}
	
	/**
	 * 比较两个字符串（大小写不敏感）。
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean equalsIgnoreCase(String str1, String str2) {
		if (str1 == null) {
			return str2 == null;
		}
		
		return str1.equalsIgnoreCase(str2);
	}
	
	/**
	 * 字符串转大写
	 * @param str
	 * @return
	 */
	public static String toUpperCase(String str) {
		if (str == null) {
			return null;
		}
		
		return str.toUpperCase();
	}
	
	/**
	 * 字符串转小写
	 * @param str
	 * @return
	 */
	public static String toLowerCase(String str) {
		if (str == null) {
			return null;
		}
		
		return str.toLowerCase();
	}
}
