package org.tedu.cloudnote.service;

import org.tedu.cloudnote.util.NoteResult;

/**
 * 笔记分享业务
 * @author zjh
 *
 */
public interface ShareService {

	/**
	 * 验证笔记是否分享
	 * 和添加笔记分享
	 * @param noteID
	 * @return
	 */
	public NoteResult shareNote(String noteID,  String noteTypeID);
	
	/**
	 * 根据笔记名 模糊查询分享笔记
	 * @param noteTitle
	 * @return
	 */
	public NoteResult shareSearch(String noteTitle);
	
	/**
	 * 查看笔记预览
	 * @param shareID
	 * @return
	 */
	public NoteResult loadShare(String shareID);
	
	
	
	
}
