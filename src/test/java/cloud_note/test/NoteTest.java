package cloud_note.test;

import java.util.List;

import javax.validation.Constraint;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tedu.cloudnote.dao.NoteDao;
import org.tedu.cloudnote.entity.Note;
import org.tedu.cloudnote.service.NoteService;



public class NoteTest {
	
	private NoteDao dao;
	
	@Before
	public void init() {
		ApplicationContext ac
		 	= new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		this.dao = ac.getBean("noteDao",NoteDao.class);
	}
	
	@Test
	public void note() {
//		ApplicationContext ac
//		 = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
//		
//		NoteDao dao = ac.getBean("noteDao",NoteDao.class);
//		
//		List<Note> n = dao.findByBookId("c8d81ee5-f8cd-49e8-b2e6-ab174a926d95");
//		
//		System.out.println(n.get(0).getCn_note_id());
//		
//		Note no = dao.findById("3f61785d-c808-4cf9-9009-d2f88e5bbe2f");
//		System.out.println(no.getCn_note_body());
//		System.out.println(no.getCn_note_id());
		
		
		
	}
	
	@Test
	public void findById() {
//		ApplicationContext ac
//		 = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
//		
////		NoteService a = ac.getBean("noteService",NoteService.class);
////		a.updateNote("1", "2", "3");
//		
//		NoteDao dao = ac.getBean("noteDao", NoteDao.class);
//		dao.updateStatus("003ec2a1-f975-4322-8e4d-dfd206d6ac0c");
		
	}
	
	@Test
	public void test2() {
		String noteid = "e1fb7cf8-e8d0-4f50-8ff5-eef18aad83ad";
		String bookid = "12119052-874c-4341-b85d-6529e171ed83";
		
		Note note = new Note();
		note.setCn_notebook_id(bookid);
		note.setCn_note_id(noteid);
		dao.updateBookId(note);
	}
}
