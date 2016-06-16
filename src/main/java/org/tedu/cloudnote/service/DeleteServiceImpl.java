package org.tedu.cloudnote.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tedu.cloudnote.dao.DeleteDao;
import org.tedu.cloudnote.entity.Note;
import org.tedu.cloudnote.util.NoteResult;

@Service("deleteService")
public class DeleteServiceImpl implements DeleteService{

	@Resource
	private DeleteDao deleteDao;
	
	
	@Override
	public NoteResult deleteByNoteId(String noteID) {
		NoteResult result = new NoteResult();
		
		deleteDao.deleteByNoteID(noteID);
		
		result.setMsg("删除成功");
		result.setStatus(0);
		return result;
	}

	@Override
	public NoteResult findDeleteList(String userID) {
		NoteResult result = new NoteResult();
		
		List<Note> notes = deleteDao.findDeleteList(userID);
		
		result.setData(notes);
		result.setStatus(0);
		
		return result;
	}

	@Override
	public NoteResult deleteReplay(String bookID, String noteId) {
		
		NoteResult result = new NoteResult();
		Note note = new Note();
		
		note.setCn_note_id(noteId);
		note.setCn_notebook_id(bookID);
		
		deleteDao.deleteReplay(note);
		
		result.setMsg("操作成功!");
		result.setStatus(0);
		return result;
	}
	
	
	
}
