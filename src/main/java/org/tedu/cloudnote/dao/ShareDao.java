package org.tedu.cloudnote.dao;

import org.tedu.cloudnote.entity.Share;

public interface ShareDao {

	/**
	 * 保存笔记分享
	 * @param share
	 */
	public void save(Share share);
	
	/**
	 * 根据noteID查询 share
	 * @param noteID
	 * @return
	 */
	public Share findByNoteId(String noteID);
}
