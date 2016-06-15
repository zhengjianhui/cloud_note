package org.tedu.cloudnote.controller.share;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tedu.cloudnote.service.ShareService;
import org.tedu.cloudnote.util.NoteResult;


@Controller
@RequestMapping("/share")
public class ShareNoteController {

	@Resource
	private ShareService shareService;
	
	@RequestMapping("/share.do")
	@ResponseBody
	public NoteResult execute(String noteID) {

		return shareService.shareNote(noteID);
	}
}
