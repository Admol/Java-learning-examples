/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved.
 */

/*
 * 修订记录：
 * jingling@yiji.com 下午3:06:43 / wjl 创建
 */
package net.admol.basiweb.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * 
 * 
 * @author jingling@yiji.com / wjl
 * 
 */
@Controller
public class AnnotationTest {
	
	@RequestMapping(value = "/test.htm")
	public String TestVelocity(ModelMap mdelMap) {
		mdelMap.addAttribute("test", "hello , this is velocity!");
		return "/testView/testVelocity.vm";
	}
}
