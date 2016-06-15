package org.tedu.cloudnote.service;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tedu.cloudnote.dao.BookDao;
import org.tedu.cloudnote.entity.Book;
import org.tedu.cloudnote.util.NoteResult;
import org.tedu.cloudnote.util.NoteUtil;

@Service("bookService")
public class BookServiceImpl implements BookService {

	@Resource
	private BookDao dao;
	
	@Override
	public NoteResult loadUserBooks(String userID) {
		NoteResult result = new NoteResult();
		
		// 获取所有笔记
		List<Book> books = dao.loadUserBooks(userID);
		
		result.setData(books);
		result.setStatus(0);
		result.setMsg("查询笔记成功");
		return result;
	}

	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
	@Override
	public NoteResult addBook(String userID, String bookName) {
		NoteResult result = new NoteResult();
		
		Book book = new Book();
		
		String bookID = NoteUtil.createId();
		
		book.setCn_notebook_createtime(new Timestamp(System.currentTimeMillis())); //设置创建时间
		book.setCn_notebook_desc("");
		book.setCn_notebook_type_id("5"); //normal
		book.setCn_notebook_id(bookID); // 设置笔记本id
		book.setCn_notebook_name(bookName);
		book.setCn_user_id(userID);
		
		dao.save(book);
		
		result.setMsg("创建笔记本成功");
		result.setStatus(0);
		// 返回笔记本id
		result.setData(bookID);
		return result;
	}

	@Override
	public NoteResult renameBook(String bookID, String bookName) {
		
		Book book = new Book();
		book.setCn_notebook_id(bookID);
		book.setCn_notebook_name(bookName);
		
		dao.rename(book);
		
		NoteResult result = new NoteResult();
		result.setMsg("修改成功");
		result.setStatus(0);
		return result;
	}
	
}
