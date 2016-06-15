package org.tedu.cloudnote.controller.book;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tedu.cloudnote.service.BookService;
import org.tedu.cloudnote.util.NoteResult;


/**
 * 笔记本重命名
 * @author zjh
 *
 */
@Controller
@RequestMapping("/book")
public class RenameBookController {

	@Resource
	private BookService bookService;
	
	
	@RequestMapping("/rename.do")
	@ResponseBody
	public NoteResult execute(String bookID, String bookName) {
		return bookService.renameBook(bookID, bookName);
	}
}
