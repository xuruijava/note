package com.aiyou.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aiyou.bean.T_MALL_USER_ACCOUNT;
import com.aiyou.mapper.LoginMapper;
import com.aiyou.util.MyJsonUtil;

@Controller
public class LoginController {

	@Autowired
	LoginMapper loginMapper;// 需要远程调用用户认证的ws接口

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "sale_index";
	}

	@RequestMapping("goto_login0210")
	public String goto_login0210() {
		return "sale_login";
	}

	@RequestMapping("login")
	public String login0210(HttpServletResponse response, T_MALL_USER_ACCOUNT user, HttpSession session, ModelMap map) {
		T_MALL_USER_ACCOUNT user_login = loginMapper.select_user_by_mch_mm(user);

		if (user_login == null) {
			map.put("err", "用户名和密码错误");
			return "sale_index";
		} else {
			session.setAttribute("user_login", user_login);

			String object_to_json = MyJsonUtil.object_to_json(user_login);
			Cookie cookie = new Cookie("user_login_cookie", object_to_json);

			cookie.setMaxAge(60 * 60);
			response.addCookie(cookie);
			
			response.addCookie(new Cookie("test","test"));
			return "redirect:/index.do";
		}
	}

}
