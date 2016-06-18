package org.tedu.cloudnote.dao;

import java.util.List;

import org.tedu.cloudnote.entity.Book;

public interface BookDao {
	
	/**
	 * 根据用户id 查询所属的所有笔记本
	 * @param userID
	 * @return
	 */
	public List<Book> loadUserBooks(Book book);
	
	
	/**
	 * 保存新建笔记本
	 * @param book
	 */
	public void save(Book book);
	
	/**
	 * 修改笔记本名
	 * @param book
	 */
	public void rename(Book book);
}
