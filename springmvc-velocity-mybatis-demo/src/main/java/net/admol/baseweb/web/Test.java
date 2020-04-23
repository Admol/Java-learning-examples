/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved.
 */

/*
 * 修订记录：
 * jingling@yiji.com 下午3:19:40 / wjl 创建
 */
package net.admol.baseweb.web;

import java.util.List;

import net.admol.baseweb.dal.dao.UserMapper;
import net.admol.baseweb.dal.dateobject.User;
import net.admol.baseweb.dal.dateobject.UserExample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * 
 * @author admol
 * 
 */
@Controller
public class Test {
	@Autowired
	private UserMapper userMapper;
	
	private Logger logger = LoggerFactory.getLogger(Test.class);
	
	@RequestMapping(value = "/test.htm")
	public String test(ModelMap mdelMap) {
		mdelMap.addAttribute("test", "hello , this is velocity!!!");
		testDB(mdelMap);
		return "/testView/testVelocity.vm";
	}
	
	@Transactional
	public void testDB(ModelMap mdelMap) {
		UserExample ss = new UserExample();
		ss.createCriteria().andUserIdEqualTo("1000");
		List<User> list = userMapper.selectByExample(ss);
		mdelMap.addAttribute("list", list);
		logger.info("测试结果size:{}", list.size());
		logger.debug("测试结果size:{}", list.size());
		logger.error("测试结果size:{}", list.size());
		logger.warn("测试结果size:{}", list.size());
	}
	
	@RequestMapping()
	public String register() {
		
		return null;
	}
}
