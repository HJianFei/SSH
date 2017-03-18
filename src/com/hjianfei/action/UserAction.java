package com.hjianfei.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjianfei.entity.User;
import com.hjianfei.service.UserService;
import com.hjianfei.utils.JSONUtils;

public class UserAction {

	private User user;
	@Resource(name = "UserService")
	private UserService userService;
	HttpServletRequest request = ServletActionContext.getRequest();
	
	public String saveUser() {
		String user_phone = request.getParameter("user_phone");
		String user_password = request.getParameter("user_pwd");
		User user = new User();
		user.setUser_phone(user_phone);
		user.setUser_password(user_password);
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			userService.save(user);
			map.put("code", "200");
			map.put("msg", "注册成功");
		} catch (Exception e) {
			if (e.getMessage().startsWith("Duplicate entry")) {
				map.put("code", "404");
				map.put("msg", "用户已存在");
			} else {
				map.put("code", "500");
				map.put("msg", "服务器出错啦");
			}
		}
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	

}
