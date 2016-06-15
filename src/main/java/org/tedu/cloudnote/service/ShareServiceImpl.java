package org.tedu.cloudnote.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tedu.cloudnote.dao.NoteDao;
import org.tedu.cloudnote.dao.ShareDao;
import org.tedu.cloudnote.entity.Note;
import org.tedu.cloudnote.entity.Share;
import org.tedu.cloudnote.util.NoteResult;
import org.tedu.cloudnote.util.NoteUtil;

@Service("shareService")
public class ShareServiceImpl implements ShareService{
	
	@Resource
	private NoteDao noteDao;
	
	@Resource
	private ShareDao shareDao;

	@Override
	public NoteResult shareNote(String noteID) {
		NoteResult result = new NoteResult();
		
		// 检查笔记是否分享过
		Share share = shareDao.findByNoteId(noteID);
		if(share != null) {
			result.setMsg("该笔记以分享");
			result.setStatus(2);
			return result;
		} else {
			share = new Share();
		}
		
		// 获取笔记本信息
		Note note = noteDao.findById(noteID);
		
		share.setCn_note_id(noteID);
		share.setCn_share_body(note.getCn_note_body());
		
		String shareID = NoteUtil.createId();
		share.setCn_share_id(shareID);
		share.setCn_share_title(note.getCn_note_title());
		
		shareDao.save(share);
		// 修改 where cn_note_id 字段
		noteDao.updateNoteByType(noteID);
		
		result.setMsg("分享成功");
		result.setStatus(0);
		return result;
	}

}
