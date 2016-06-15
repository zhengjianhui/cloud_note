package org.tedu.cloudnote.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tedu.cloudnote.service.NoteService;
import org.tedu.cloudnote.util.NoteResult;


/**
 * 处理笔记
 * @author zjh
 *
 */
@Controller
@RequestMapping("/note")
public class LoadNotesController {
	
	@Resource
	private NoteService noteService;
	
	@RequestMapping("/loadnotes.do")
	@ResponseBody
	public NoteResult execute(String bookId) {
		
		return noteService.loadBookNotes(bookId);
	}
}
