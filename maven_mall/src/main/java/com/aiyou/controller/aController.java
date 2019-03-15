package com.aiyou.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aiyou.bean.T_MALL_USER_ACCOUNT;
import com.aiyou.mapper.LoginMapper;
import com.aiyou.service.AServer;

@Controller
public class aController {
	Logger logger = Logger.getLogger(aController.class);
	@Autowired
	AServer aServer;

	@RequestMapping("into")
	public String a(HttpServletResponse response) {
		T_MALL_USER_ACCOUNT a = new T_MALL_USER_ACCOUNT();
		a.setUsername("bb");
		a.setPassword("123");
		String query = aServer.query(a);
		System.out.println("query"+query);
		return "index";
	}
}
