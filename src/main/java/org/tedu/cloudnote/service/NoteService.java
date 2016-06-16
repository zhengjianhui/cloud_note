package org.tedu.cloudnote.service;

import org.tedu.cloudnote.util.NoteResult;

public interface NoteService {
	
	/**
	 * 对应bookID 查询 note表记录
	 * @param bookId
	 * @return
	 */
	public NoteResult loadBookNotes(String bookId);
	
	
	/**
	 * 对应noteID 查询 note表 获取笔记 title body
	 * @param noteID
	 * @return
	 */
	public NoteResult loadNote(String noteID);
	
	/**
	 * 更新笔记
	 * @param noteID
	 * @param noteTitle
	 * @param noteBody
	 * @return
	 */
	public NoteResult updateNote(String noteID, String noteTitle, String noteBody);
	
	/**
	 * 新建笔记
	 * @param noteName
	 * @param bookID
	 * @return
	 */
	public NoteResult save(String userID, String noteName, String bookID);
	
	/**
	 * 删除笔记
	 * @param noteID
	 * @return
	 */
	public NoteResult deleteNote(String noteID);
	
	
	/**
	 * 
	 * @param bookID 目标笔记本id
	 * @param noteID 转移笔记id
	 * @return
	 */
	public NoteResult moveNote(String bookID, String noteID);
}
