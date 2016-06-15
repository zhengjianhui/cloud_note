package cloud_note.test;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tedu.cloudnote.dao.NoteDao;
import org.tedu.cloudnote.dao.ShareDao;
import org.tedu.cloudnote.entity.Note;
import org.tedu.cloudnote.entity.Share;
import org.tedu.cloudnote.util.NoteUtil;

public class ShareTest {

	/**
	 * 测试插入
	 */
	@Test
	public void save() {
//		String str1 = "19fbb55b-0541-433b-a7cd-dba52220a447";
//		
//		ApplicationContext ac
//		 = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
//		
//		ShareDao sd =  ac.getBean("shareDao", ShareDao.class);
//		Share sh = sd.findByNoteId("c9448bc3-c39c-4a7e-83c8-a84766f2b877");
//		System.out.println(sh.getCn_share_body());
//		
//		
//		NoteDao noteDao = ac.getBean("noteDao", NoteDao.class);
//		Note note = noteDao.findById("e633e99d-c8dd-44f3-8d8e-5b0966e0927c");
////		System.out.println(note.getCn_note_body());
//		
//		if(sh == null) {
//			sh = new Share();
//		}
//		sh.setCn_share_id(NoteUtil.createId());
//		sd.save(sh);
//		
	}
	
	
	@Test
	public void updateNoteTypeID() {
		String str = "003ec2a1-f975-4322-8e4d-dfd206d6ac0c";
		
		ApplicationContext ac
		 = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		
		NoteDao noteDao = ac.getBean("noteDao", NoteDao.class);
		noteDao.updateNoteByType(str);
	}
}
