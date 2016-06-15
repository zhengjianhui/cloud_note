package org.tedu.cloudnote.controller.user;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tedu.cloudnote.service.UserService;
import org.tedu.cloudnote.util.NoteResult;

@Controller
@RequestMapping("/user")
public class UserLoginController {

	// 注入service
	@Resource
	private UserService userServiceImpl;
	
	/**
	 * @param username 接收页面传递的用户名
	 * @param password 接收页面传递的密码
	 * @return
	 */
	@RequestMapping("/login.do")
	@ResponseBody
	public NoteResult execute(String username, String password) {
		
		return userServiceImpl.checkLogin(username, password);
	}
}
