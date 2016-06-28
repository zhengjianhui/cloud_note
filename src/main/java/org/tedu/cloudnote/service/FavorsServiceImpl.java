package org.tedu.cloudnote.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tedu.cloudnote.dao.FavorsDao;
import org.tedu.cloudnote.dao.NoteDao;
import org.tedu.cloudnote.dao.ShareDao;
import org.tedu.cloudnote.entity.Favors;
import org.tedu.cloudnote.entity.Note;
import org.tedu.cloudnote.entity.Share;
import org.tedu.cloudnote.util.NoteResult;
import org.tedu.cloudnote.util.NoteUtil;

@Service("favorsService")
public class FavorsServiceImpl implements FavorsService {
	
	@Resource
	private FavorsDao favorsDao;
	
	@Resource
	private NoteDao noteDao;
	
	@Resource
	private ShareDao shareDao;
	
	@Transactional
	@Override
	public NoteResult insertFavors(String shareID, String userID, String bookID, String favorsID, String stutasType) {
		NoteResult result = new NoteResult();
		System.err.println(favorsID);
		Favors favors = new Favors();
		favors.setCnShareId(shareID);
		favors.setCnUserId(userID);
		
		System.out.println(stutasType);
		
		
		// 用于判断笔记是否收藏过
		if(favorsDao.countShareById(favors) > 0) {
			result.setMsg("该笔记已经收藏");
			result.setStatus(1);
			return result;
		} 
		
	
		if("2".equals(stutasType)) {
			
			// 删除 favors表中记录
			favorsDao.deleteFavors(favorsID);
			// 删除note表中记录
			favorsDao.deleteNoteByFavaorsID(favorsID);
			
			result.setMsg("以取消收藏");
			result.setStatus(1);
			return result;
		}
		
		// 生成id
		favors.setCnFavorsId(NoteUtil.createId());
		
		favorsDao.insertFavors(favors);
		Share share = shareDao.findById(shareID);
		
		Note note = new Note();
		note.setCn_note_body(share.getCn_share_body());
		note.setCn_note_title(share.getCn_share_title());
		note.setCn_note_id(NoteUtil.createId());
		note.setCn_notebook_id(bookID);
		note.setCn_user_id(userID);
		note.setCn_favors(favors.getCnFavorsId());
		
		noteDao.save(note);
		
		result.setMsg("收藏成功");
		result.setStatus(0);
		
		return result;
		
	}

}
