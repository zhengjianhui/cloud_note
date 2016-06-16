package org.tedu.cloudnote.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tedu.cloudnote.service.NoteService;
import org.tedu.cloudnote.util.NoteResult;


/**
 * 处理笔记转移
 * @author zjh
 *
 */
@Controller
@RequestMapping("/note")
public class MoveNoteController {

	@Resource
	private NoteService noteService;
	
	/**
	 * 
	 * @param bookID 目标笔记本id
	 * @param noteID 转移笔记id
	 * @return
	 */
	@RequestMapping("/move.do")
	@ResponseBody
	public NoteResult execute(String bookID, String noteID) {
		return noteService.moveNote(bookID, noteID);
	}
}
