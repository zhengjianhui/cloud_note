package org.tedu.cloudnote.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tedu.cloudnote.service.UserService;
import org.tedu.cloudnote.util.NoteResult;

/**
 * 处理用户注册
 * @author zjh
 *
 */
@Controller
@RequestMapping("/user")
public class UserRegistController {
	
	// 注入service
	@Resource
	private UserService userServiceImpl;
	
	/**
	 * 处理用户注册请求
	 * @return
	 */
	@RequestMapping("/regist.do")
	@ResponseBody
	public NoteResult execute(String username, String password, String nickname) {
		System.out.println(username + "," + password + "," + nickname);
		return  userServiceImpl.registUser(username, password, nickname);
	}
}
