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
	public NoteResult shareNote(String noteID);
}
