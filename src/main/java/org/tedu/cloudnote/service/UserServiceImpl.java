package org.tedu.cloudnote.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tedu.cloudnote.dao.UserDao;
import org.tedu.cloudnote.entity.User;
import org.tedu.cloudnote.util.NoteResult;
import org.tedu.cloudnote.util.NoteUtil;


@Service("userService")
public class UserServiceImpl implements UserService {
	
	// 注入dao
	@Resource
	private UserDao dao;

	/**
	 * 执行注册逻辑
	 */
	@Override
	public NoteResult registUser(String name, String password, String nick) {
		// 建立json状态对象
		NoteResult result = new NoteResult();
		
		User user = dao.findByName(name);
		if(user != null) {
			result.setStatus(1);
			result.setMsg("用户已存在！");
			return result;
		} else {
			// user 查询出来有可能是一个空对象，重新new一个防止空指针
			user = new User();
		}
		
		// 保存用户信息 
		
		user.setCn_user_id(NoteUtil.createId());
		user.setCn_user_name(name);
		user.setCn_user_password(NoteUtil.md5(password));
		user.setCn_user_nick(nick);
		
		dao.save(user);
		
		result.setMsg("注册成功");
		result.setStatus(0);
		return result;
	}

	/**
	 * 执行登入逻辑
	 */
	@Override
	public NoteResult checkLogin(String name, String password) {
		// 获取json 状态对象
		NoteResult result = new NoteResult();
		// 根据账号获取用户资料
		User user = dao.findByName(name);
		
		// 验证用户账号
		if(user == null) {
			result.setStatus(1);
			result.setMsg("用户不存在");
			
			return result;
		}
		// 验证密码
		if(!NoteUtil.md5(password).equalsIgnoreCase(user.getCn_user_password())) {
			result.setStatus(2);
			result.setMsg("密码错误");
			
			return result;
		}
		
		// 将用户身份id返回 在前台页面保存为cookie
		result.setData(user.getCn_user_id());
		result.setStatus(0);
		result.setMsg("登入成功");
		
		return result;
	}


}
