/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved.
 */

/*
 * 修订记录：
 * jingling@yiji.com 上午10:16:42 / wjl 创建
 */
package com.admol.shellexec;

import java.io.IOException;

/**
 * 
 * 打开外部程序测试
 * @author admol
 * 
 */
public class OpenOtherPro {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Runtime runtime = Runtime.getRuntime();
			runtime.exec("notepad.exe");
			runtime.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
