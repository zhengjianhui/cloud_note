package org.tedu.cloudnote.controller.delete;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tedu.cloudnote.service.DeleteService;
import org.tedu.cloudnote.util.NoteResult;

/**
 * 处理恢复笔记
 * @author zjh
 *
 */
@Controller
@RequestMapping("/delete")
public class deleteReplayController {

	@Resource
	private DeleteService deleteService;
	
	@ResponseBody
	@RequestMapping("/deleteReplay.do")
	public NoteResult execute(String bookID, String noteID) {
		
		return deleteService.deleteReplay(bookID, noteID);
	}
}
