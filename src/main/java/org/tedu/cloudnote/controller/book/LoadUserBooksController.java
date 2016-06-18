package org.tedu.cloudnote.controller.book;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tedu.cloudnote.service.BookService;
import org.tedu.cloudnote.util.NoteResult;

/**
 * 处理笔记
 * @author zjh
 *
 */
@Controller
@RequestMapping("book")
public class LoadUserBooksController {
	
	@Resource
	private BookService bookService;

	@RequestMapping("/loadbooks.do")
	@ResponseBody
	public NoteResult execute(String userID, String bookType) {
		return bookService.loadUserBooks(userID, bookType);
	}
	
}
