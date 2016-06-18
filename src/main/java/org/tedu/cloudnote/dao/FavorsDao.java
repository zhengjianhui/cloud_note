package org.tedu.cloudnote.dao;

import org.tedu.cloudnote.entity.Favors;

public interface FavorsDao {

	/**
	 * 查看笔记是否分享
	 * @param share
	 * @return
	 */
	public Integer countShareById(Favors favors);
	
	/**
	 * 插入分享记录
	 * @param share
	 */
	public void insertFavors(Favors favors);
	
	/**
	 * 取消收藏
	 * @param favorsID
	 */
	public void deleteFavors(String favorsID);
	
	/**
	 * 取消收藏
	 * @param favorsID
	 */
	public void deleteNoteByFavaorsID(String favorsID);
}
