package org.tedu.cloudnote.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tedu.cloudnote.dao.NoteDao;
import org.tedu.cloudnote.dao.ShareDao;
import org.tedu.cloudnote.entity.Note;
import org.tedu.cloudnote.util.NoteResult;
import org.tedu.cloudnote.util.NoteUtil;

/**
 * 处理笔记
 * @author zjh
 *
 */
@Service("noteService")
public class NoteServiceImpl implements NoteService{

	@Resource
	private NoteDao dao;
	
	@Resource
	private ShareDao shareDao;
	
	@Override
	public NoteResult loadBookNotes(String bookId) {
		// 建立json 状态对象
		NoteResult result = new NoteResult();
		
		List<Note> notes = dao.findByBookId(bookId);
		
		result.setData(notes);
		result.setMsg("查询笔记成功");
		result.setStatus(0);
		
		return result;
	}

	@Override
	public NoteResult loadNote(String noteID) {
		// 建立json 状态对象
		NoteResult result = new NoteResult();
				
		Note note = dao.findById(noteID);
		
		result.setData(note);
		result.setMsg("查询笔记成功");
		result.setStatus(0);
		
		return result;
	}

	
	/**
	 * 执行保存
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,rollbackFor=Exception.class)
	public NoteResult updateNote(Note note) {
		// 建立json 状态对象
		NoteResult result = new NoteResult();
		
		
//		Note note = new Note();
//		note.setCn_note_body(note.getCn_note_body());
//		note.setCn_note_id(note.getCn_note_id());
//		note.setCn_note_title(note.getCn_note_title());
		
		dao.dynamicUpdate(note);
		
//		System.err.println(noteTypeID);
		
		if("2".equals(note.getCn_note_type_id())) {
			// 同步更新
			shareUpdate(note);
		}
	
		
		result.setMsg("保存成功");
		result.setStatus(0);
		
		return result;
	}
	
	

	@Override
	public void shareUpdate(Note note) {
		shareDao.updateShareBody(note);
	}
	
	

	@Override
	public NoteResult save(String userID, String noteName, String bookID) {
		Note note = new Note();
		// 用户id
		note.setCn_user_id(userID);
		// 笔记本id
		note.setCn_notebook_id(bookID);
		// 笔记名
		note.setCn_note_title(noteName);
	
		// 笔记id 
		String noteID = NoteUtil.createId();
		note.setCn_note_id(noteID);
		
		// 创建时间
		Long time = System.currentTimeMillis();
		note.setCn_note_create_time(time);
		// 最后修改时间
		note.setCn_note_last_modify_time(time);
		
		// 保存笔记
		dao.save(note);
		
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("创建笔记成功");
		result.setData(noteID);//返回笔记ID
		return result;
	}

	@Override
	public NoteResult deleteNote(String noteID) {
		NoteResult result = new NoteResult();
		
		dao.updateStatus(noteID);
		
		result.setMsg("删除成功");
		result.setStatus(0);
		
		return result;
	}

	@Override
	public NoteResult moveNote(String bookID, String noteID) {
		NoteResult result = new NoteResult();
		Note note = new Note();
		
		note.setCn_notebook_id(bookID);
		note.setCn_note_id(noteID);
		dao.updateBookId(note);
		
		result.setStatus(0);
		result.setMsg("转移成功");
		return result;
	}

}
