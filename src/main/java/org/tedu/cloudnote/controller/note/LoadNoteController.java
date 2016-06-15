package org.tedu.cloudnote.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tedu.cloudnote.service.NoteService;
import org.tedu.cloudnote.util.NoteResult;

/**
 * 处理笔记内容与标题
 * @author zjh
 *
 */
@Controller
@RequestMapping("/note")
public class LoadNoteController {
	
	@Resource
	private NoteService noteService;
	
	@RequestMapping("/load.do")
	@ResponseBody
	public NoteResult execute(String noteID) {
		
		return noteService.loadNote(noteID);
	}

}
