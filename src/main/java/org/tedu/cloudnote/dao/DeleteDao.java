package org.tedu.cloudnote.dao;

import java.util.List;

import org.tedu.cloudnote.entity.Note;

public interface DeleteDao {

	/**
	 * 根据note 删除笔记
	 * @param noteID
	 */
	public void deleteByNoteID(String noteID);
	
	/**
	 * 查询所有 回收站笔记 
	 * @param userID
	 * @return
	 */
	public List<Note> findDeleteList(String userID);
	
	/**
	 * 恢复笔记操作
	 * @param note
	 */
	public void deleteReplay(Note note);
}
