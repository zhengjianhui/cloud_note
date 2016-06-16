package org.tedu.cloudnote.controller.delete;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tedu.cloudnote.service.DeleteService;
import org.tedu.cloudnote.util.NoteResult;


/**
 * 处理回收站 笔记彻底删除
 * @author zjh
 *
 */
@RequestMapping("/delete")
@Controller
public class deleteByNoteIdContorller {

	@Resource
	private DeleteService deleteService;
	
	@RequestMapping("deleteByID")
	@ResponseBody
	public NoteResult execute(String noteID) {
		
		return deleteService.deleteByNoteId(noteID);
	}
}
