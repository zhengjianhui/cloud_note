package org.tedu.cloudnote.controller.delete;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tedu.cloudnote.service.DeleteService;
import org.tedu.cloudnote.util.NoteResult;

/**
 * 查询保存于回收站的笔记
 * @author zjh
 *
 */
@Controller
@RequestMapping("/delete")
public class DeleteController {

	@Resource
	
	private DeleteService deleteService;
	
	@RequestMapping("/deleteList.do")
	@ResponseBody
	public NoteResult execute(String userID) {
		
		return deleteService.findDeleteList(userID);
	}
}
