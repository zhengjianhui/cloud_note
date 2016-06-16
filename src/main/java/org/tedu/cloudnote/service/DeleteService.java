package org.tedu.cloudnote.service;

import org.tedu.cloudnote.entity.Note;
import org.tedu.cloudnote.util.NoteResult;


public interface DeleteService {
	
	/**
	 * 根据id销毁cn_note 表中对应记录
	 * @param UserID
	 * @param NoteID
	 * @return
	 */
	public NoteResult deleteByNoteId(String noteID);
	
	/**
	 * 查询所有 回收笔记
	 * @param userID
	 * @return
	 */
	public NoteResult findDeleteList(String userID);
	
	

	/**
	 * 处理恢复笔记
	 * @param bookID
	 * @param noteId
	 * @return
	 */
	public NoteResult deleteReplay(String bookID, String noteId);
	
	
	
	
}
