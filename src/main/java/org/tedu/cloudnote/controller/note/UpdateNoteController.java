package org.tedu.cloudnote.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tedu.cloudnote.entity.Note;
import org.tedu.cloudnote.service.NoteService;
import org.tedu.cloudnote.util.NoteResult;

/**
 * 保存笔记
 * @author zjh
 *
 */
@Controller
@RequestMapping("/note")
public class UpdateNoteController {

	@Resource
	private NoteService noteService;
	
	@RequestMapping("/update.do")
	@ResponseBody
	public NoteResult execute(Note note) {
		return noteService.updateNote(note);
	}
}
