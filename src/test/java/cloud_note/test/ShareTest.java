package cloud_note.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tedu.cloudnote.dao.ShareDao;
import org.tedu.cloudnote.entity.Share;


public class ShareTest {
	
//	private ShareDao sd;
//	
//	@Before
//	public void init() {
//		ApplicationContext ac
//		 	= new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
//		
//		this.sd =  ac.getBean("shareDao", ShareDao.class);
//	}
	
	
	/**
	 * 测试插入
	 */
	@Test
	public void save() {
		String str1 = "19fbb55b-0541-433b-a7cd-dba52220a447";
		
//		ApplicationContext ac
//		 = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		
//		ShareDao sd =  ac.getBean("shareDao", ShareDao.class);
//		System.out.println(sd);
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
//		String str = "003ec2a1-f975-4322-8e4d-dfd206d6ac0c";
//		
//		ApplicationContext ac
//		 = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
//		
//		NoteDao noteDao = ac.getBean("noteDao", NoteDao.class);
//		noteDao.updateNoteByType(str);
	}
	
	
	@Test
	public void test2() {
		
		ApplicationContext ac
		 = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		
		ShareDao dao =  ac.getBean("shareDao", ShareDao.class);
//		System.out.println(dao);
//		List<Share> ss = dao.findLikeTitle("dddd");
//		System.out.println(ss.get(0).getCn_share_id());
		
		System.out.println(dao.findById("186a5ab3-5be7-4fb1-8378-3432cf774edb").getCn_share_body());
	}
}
