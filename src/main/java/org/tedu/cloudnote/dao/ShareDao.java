package org.tedu.cloudnote.dao;

import java.util.List;

import org.tedu.cloudnote.entity.Note;
import org.tedu.cloudnote.entity.Share;

public interface ShareDao {

	/**
	 * 保存笔记分享
	 * @param share
	 */
	public void save(Share share);
	
	/**
	 * 根据noteID查询 note
	 * @param noteID
	 * @return
	 */
	public Share findByNoteId(String noteID);
	
	
	/**
	 * 根据笔记名 模糊查询 分享笔记
	 * @param noteTitile
	 * @return
	 */
	public List<Share> findLikeTitle(String noteTitle);
	
	/**
	 * 处理分享笔记预览
	 * @param shareID
	 * @return
	 */
	public Share findById(String shareID);
	
	/**
	 * 根据noteID 删除对应记录
	 * @param noteID
	 * @return
	 */
	public void deleteShare(String noteID);
	
	
	/**
	 * 修改分享
	 * @param note
	 */
	public void updateShareBody(Note note);
	
}
