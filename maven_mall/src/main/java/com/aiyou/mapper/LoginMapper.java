package com.aiyou.mapper;

import com.aiyou.bean.T_MALL_USER_ACCOUNT;

public interface LoginMapper {

	T_MALL_USER_ACCOUNT select_user_by_mch_mm(T_MALL_USER_ACCOUNT user);

}
