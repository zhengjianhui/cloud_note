package org.tedu.cloudnote.service;

import org.tedu.cloudnote.util.NoteResult;

public interface FavorsService {
	

	
	/**
	 * 插入分享记录
	 * @param share
	 * @return 
	 */
	public NoteResult insertFavors(String shareID, String userID, String bookID, String favors,  String stutasType);
}
