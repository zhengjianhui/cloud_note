package cloud_note.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tedu.cloudnote.dao.DeleteDao;
import org.tedu.cloudnote.entity.Note;

public class Delete {

	@Test
	public void test() {
		String userID = "48595f52-b22c-4485-9244-f4004255b972";
		ApplicationContext ac
			= new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		
		DeleteDao dao = ac.getBean("deleteDao", DeleteDao.class);
		
		List<Note> notes = dao.findDeleteList(userID);
		
		for(Note n : notes) {
			System.out.println(n.getCn_note_id());
		}
		
//	
		
	}
}
