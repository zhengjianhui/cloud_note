package org.tedu.cloudnote.service;

import org.tedu.cloudnote.util.NoteResult;

public interface BookService {
	
	/**
	 * 处理登入后默认载入所有笔记
	 */
	public NoteResult loadUserBooks(String userID);
	
	/**
	 * 处理添加笔记本
	 */
	public NoteResult addBook(String userID, String bookName);
	
	/**
	 * 笔记本修改 重命名
	 * @param bookID
	 * @param bookName
	 * @return
	 */
	public NoteResult renameBook(String bookID, String bookName);
}
