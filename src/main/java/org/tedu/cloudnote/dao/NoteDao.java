package org.tedu.cloudnote.dao;

import java.util.List;

import org.tedu.cloudnote.entity.Note;

/**
 * 处理笔记
 * @author zjh
 *
 */
public interface NoteDao {
	
	/**
	 * 根据bookID 查询 note表
	 * @param id
	 * @return
	 */
	public List<Note> findByBookId(String id);
	
	/**
	 * 根据 noteID 查询笔记内容
	 */
	 public Note findById(String id);
	 
	 /**
	  * 保存笔记
	  */
	 public void dynamicUpdate(Note note);
	 
	 /**
	  *  新建笔记
	  */
	 public void save(Note note);
	 
	 /**
	  * 删除笔记 
	  * 修改status_id=2 
	  */
	 public void updateStatus(String noteID);
	 
	 /**
	  * 修改 cn_note_type_id 字段 
	  * '1' 为分享 '2' 分享 
	  * @param noteID
	  */
	 public void updateNoteByType(Note note);
	 
	 /**
	  * 修改cn_notebook_id
	  * @param note
	  */
	 public void updateBookId(Note note);
	 
}
