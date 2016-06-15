package org.tedu.cloudnote.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tedu.cloudnote.service.NoteService;
import org.tedu.cloudnote.util.NoteResult;


@Controller
@RequestMapping("/note")
public class AddNoteController {

	@Resource
	private NoteService noteService;

	@RequestMapping("/add.do")
	@ResponseBody
	public NoteResult execute(String userID, String noteName, String bookID) {
		
		System.out.println(userID);
		return noteService.save(userID, noteName, bookID);
//		return null;
	}

}
