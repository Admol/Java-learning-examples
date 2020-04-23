/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved.
 */

/*
 * 修订记录：
 * jingling@yiji.com 下午2:01:31 / wjl 创建
 */
package net.admol.basiweb.web;

import net.admol.baseweb.util.MD5Utils;

/**
 * 
 * 
 * @author admol
 * 
 */
public class TestMD5 {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String pwd = "admol123456++--";
		
		System.out.println(MD5Utils.encoderByMd5(pwd));
		System.out.println(MD5Utils.checkMD5(pwd, "f56bcacb6e7dfc3cb7e47edd79f02e46"));
	}
	
}
