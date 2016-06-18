package cloud_note.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tedu.cloudnote.service.FavorsService;

public class FavorsTest {

	@Test
	public void t() {
		ApplicationContext ac
		 = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
	
		FavorsService dao = ac.getBean("favorsService", FavorsService.class);
	}
}
