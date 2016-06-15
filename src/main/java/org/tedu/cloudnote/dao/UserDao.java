package org.tedu.cloudnote.dao;

import org.tedu.cloudnote.entity.User;

/**
 * 处理用户登入 注册
 * @author zjh
 *
 */
public interface UserDao {
	/**
	 * 根据用户名查询
	 * @param name
	 * @return
	 */
	public User findByName(String name);
	
	/**
	 * 根据用户输入保存注册信息
	 * @param user
	 */
	public void save(User user);
}
