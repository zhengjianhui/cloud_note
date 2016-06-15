package cloud_note.test;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tedu.cloudnote.dao.BookDao;
import org.tedu.cloudnote.entity.Book;

public class BookTest {
	
	
	private BookDao dao;
	
	/**
	 * test 方法 运行前会运行该段代码
	 */
	@Before
	public void init() {
		ApplicationContext ac
		= new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
	
		this.dao = ac.getBean("bookDao", BookDao.class);
	}
	
	
	@Test
	public void book() {
		
		
//		List<Book> b = dao.loadUserBooks("03590914-a934-4da9-ba4d-b41799f917d1");
//		System.out.println(b.get(0).getCn_notebook_name());
		
//		Book book = new Book();
//		book.setCn_notebook_id("1");
//		dao.save(book);
		
		// 断言机制
		// expected 预期结果
		// actual 	实际结果
//		String s1 = "hello";
//		String s2 = "Hello";
//		Assert.assertEquals(s1, s2);
			
		Book book = new Book();
		book.setCn_notebook_id("c2a39fab-ae81-409d-ba7e-34510549e622");
		book.setCn_notebook_name("测试笔记本修改");
		
		dao.rename(book);
	}
}
