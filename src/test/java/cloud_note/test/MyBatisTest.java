package cloud_note.test;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tedu.cloudnote.dao.UserDao;
import org.tedu.cloudnote.entity.User;
import org.tedu.cloudnote.util.NoteUtil;

public class MyBatisTest {

	@Test
	public void t() {
		ApplicationContext ac
			 = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		
		UserDao dao = ac.getBean("userDao", UserDao.class);
		
		User u = dao.findByName("demo");
		String str2 = u.getCn_user_password();
		
		System.out.println(NoteUtil.md5("123456"));
		System.out.println(str2);
		System.out.println(NoteUtil.md5("123456").equalsIgnoreCase(str2));
		
		
		
		
	}
}
