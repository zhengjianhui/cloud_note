package org.tedu.cloudnote.controller.share;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tedu.cloudnote.service.ShareService;
import org.tedu.cloudnote.util.NoteResult;

/**
 * 查看分享笔记预览
 * @author zjh
 *
 */
@Controller
@RequestMapping("/share")
public class LoadShareController {

	@Resource
	private ShareService shareService;
	
	@RequestMapping("/load.do")
	@ResponseBody
	public NoteResult execute(String shareID) {
		return shareService.loadShare(shareID);
	}
}
