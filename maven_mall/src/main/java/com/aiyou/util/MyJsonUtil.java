package com.aiyou.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import com.aiyou.bean.T_MALL_USER_ACCOUNT;
import com.google.gson.Gson;

public class MyJsonUtil {

	public static String string_to_json(String string) {
		Gson gson = new Gson();

		String json = gson.toJson(string);

		try {
			json = URLEncoder.encode(json, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return json;
	}

	public static <T> String object_to_json(T t) {
		Gson gson = new Gson();

		String json = gson.toJson(t);

		try {
			json = URLEncoder.encode(json, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return json;
	}

	public static <T> T string_to_object(String value, Class<T> t) {
		Gson gson = new Gson();
		T json_object = null;
		try {
			String decode = URLDecoder.decode(value, "utf-8");
			json_object = gson.fromJson(decode, t);

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json_object;
	}

}
