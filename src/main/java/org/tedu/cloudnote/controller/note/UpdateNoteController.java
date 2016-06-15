package org.tedu.cloudnote.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tedu.cloudnote.service.NoteService;
import org.tedu.cloudnote.util.NoteResult;

@Controller
@RequestMapping("/note")
public class UpdateNoteController {

	@Resource
	private NoteService noteService;
	
	@RequestMapping("/update.do")
	@ResponseBody
	public NoteResult execute(String noteID, String noteTitle, String noteBody) {
		
		return noteService.updateNote(noteID, noteTitle, noteBody);
	}
}
