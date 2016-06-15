package org.tedu.cloudnote.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tedu.cloudnote.service.NoteService;
import org.tedu.cloudnote.util.NoteResult;


@Controller
@RequestMapping("/note")
public class DeleteNoteController {

	@Resource
	private NoteService service;
	
	@RequestMapping("/delete.do")
	@ResponseBody
	public NoteResult execute(String noteID) {
		
		return service.deleteNote(noteID);
	}
}
