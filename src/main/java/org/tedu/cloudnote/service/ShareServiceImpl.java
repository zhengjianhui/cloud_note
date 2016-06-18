package org.tedu.cloudnote.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

	@Transactional
	@Override
	public NoteResult shareNote(String noteID,  String noteTypeID) {
		NoteResult result = new NoteResult();
		Note note = new Note();
		
		
		// 检查笔记是否分享过
//		Share share = shareDao.findByNoteId(noteID);
		
		// 如果等于2 则说明分享过 该次分享操作为取消
		if("2".equals(noteTypeID)) {

			// 删除 share 表的记录
			shareDao.deleteShare(noteID);
			// 修改cn_note_type_id 
			note.setCn_note_id(noteID);
			note.setCn_note_type_id("1");
			noteDao.updateNoteByType(note);
			
			result.setMsg("取消分享....");
			result.setStatus(0);
			return result;
		
		// 否则保存分享
		} else {
//		if(share != null) {
//			result.setMsg("该笔记以分享");
//			result.setStatus(2);
//			return result;
//		} else {
//			share = new Share();
//		}
		
			Share share = new Share();
	
			// 获取笔记本信息
			note = noteDao.findById(noteID);
			
			share.setCn_note_id(noteID);
			share.setCn_share_body(note.getCn_note_body());
			
			String shareID = NoteUtil.createId();
			share.setCn_share_id(shareID);
			share.setCn_share_title(note.getCn_note_title());
			
			// 保存记录
			shareDao.save(share);
			// 修改 where cn_note_id 字段
			note.setCn_note_id(noteID);
			note.setCn_note_type_id("2");
			noteDao.updateNoteByType(note);
			
			result.setMsg("分享成功");
			result.setStatus(0);
			return result;
		}
	}

	@Override
	public NoteResult shareSearch(String noteTitle) {
		NoteResult result = new NoteResult();
		
		List<Share> list = shareDao.findLikeTitle(noteTitle);
		
		if(list.isEmpty()) {
			result.setMsg("没有对应记录!");
			result.setStatus(1);
			return result;
		} 
		
		result.setMsg("查询成功");
		result.setStatus(0);
		result.setData(list);
		return result;
	}

	@Override
	public NoteResult loadShare(String shareID) {
		NoteResult result = new NoteResult();
		
		Share share = shareDao.findById(shareID);
		
		result.setData(share);
		result.setMsg("查询成功");
		result.setStatus(0);
		
		return result;
	}

}
