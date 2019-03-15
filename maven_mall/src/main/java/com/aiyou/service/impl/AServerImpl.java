package com.aiyou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiyou.bean.T_MALL_USER_ACCOUNT;
import com.aiyou.mapper.LoginMapper;
import com.aiyou.service.AServer;
@Service
public class AServerImpl implements AServer {
	@Autowired
	LoginMapper mapper;

	public String query(T_MALL_USER_ACCOUNT user) {
		mapper.select_user_by_mch_mm(user);
		return "12";
	}

}
