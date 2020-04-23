/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved.
 */

/*
 * 修订记录：
 * jingling@yiji.com 上午11:06:46 / wjl 创建
 */
package com.admol.shellexec;

import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.ExecuteWatchdog;

/**
 * 
 * cmd外部命令测试
 * @author admol
 * 
 */
public class CMDCommandTest {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//要执行的命令
		String command = "ping admol.net ";
		String openCommand = "notepad.exe";
		//命令行处理
		CommandLine pingCMD = CommandLine.parse(command);
		CommandLine openCMD = CommandLine.parse(openCommand);
		DefaultExecutor exec = new DefaultExecutor();
		exec.setExitValues(null);
		// 监视狗Watchdog 命令执行的超时时间
		ExecuteWatchdog watchdog = new ExecuteWatchdog(9000);
		exec.setWatchdog(watchdog);
		try {
			exec.execute(pingCMD);
			exec.execute(openCMD);
		} catch (ExecuteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
