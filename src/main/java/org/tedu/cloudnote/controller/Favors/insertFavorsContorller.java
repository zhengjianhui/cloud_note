package org.tedu.cloudnote.controller.Favors;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tedu.cloudnote.service.FavorsService;
import org.tedu.cloudnote.util.NoteResult;

@Controller
@RequestMapping("/favors")
public class insertFavorsContorller {

	@Resource
	private FavorsService favorsService;
	
	@RequestMapping("/insert.do")
	@ResponseBody
	public NoteResult execute(String shareID, String userID, String bookID,  String favors, String stutasType) {
		return favorsService.insertFavors(shareID, userID, bookID, favors, stutasType);
	}
}
