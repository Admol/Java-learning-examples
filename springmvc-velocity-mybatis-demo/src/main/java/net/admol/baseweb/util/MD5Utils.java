/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved.
 */

/*
 * 修订记录：
 * jingling@yiji.com 下午1:59:43 / wjl 创建
 */
package net.admol.baseweb.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 
 * @author admol
 * 
 */
public class MD5Utils {
	
	private static final Logger logger = LoggerFactory.getLogger(MD5Utils.class);
	static MessageDigest messageDigest = null;
	
	/**
	 * 对给定的字符串进行加密
	 * @param source
	 * @return 加密后的16进制的字符串
	 */
	public final static String encoderByMd5(String source) {
		String tmp = source.substring(0, 1)
						+ source.subSequence(source.length() - 1, source.length());
		tmp = md5(tmp);
		return md5(source + tmp);
	}
	
	private static String md5(String source) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("加密的字符串：" + source);
		}
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
							'e', 'f' };
		try {
			
			byte[] strTemp = source.getBytes();
			// 使用MD5创建MessageDigest对象
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte b = md[i];
				str[k++] = hexDigits[b >> 4 & 0xf];
				str[k++] = hexDigits[b & 0xf];
			}
			
			if (logger.isDebugEnabled()) {
				logger.debug("加密后的字符串：" + new String(str));
			}
			return new String(str);
		} catch (Exception e) {
			logger.error("md5加密出错：" + source, e);
			return null;
		}
		
	}
	
	/**
	 * 判断加码是否正确
	 * @param newStr
	 * @param oldMD5Str
	 * 
	 * @return
	 */
	public final static boolean checkMD5(String newStr, String oldMD5Str) {
		String temp = encoderByMd5(newStr);
		return (temp != null && temp.equals(oldMD5Str)) ? true : false;
	}
	
	public static String encodeByMD5(String str) {
		try {
			if (messageDigest == null)
				messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(str.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			logger.error("NoSuchAlgorithmException caught!", e);
			
		} catch (UnsupportedEncodingException e) {
			logger.error("UnsupportedEncodingException error!", e);
		}
		if (messageDigest == null)
			return "";
		byte[] byteArray = messageDigest.digest();
		
		StringBuffer md5StrBuff = new StringBuffer();
		
		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}
		
		return md5StrBuff.toString();
	}
}
