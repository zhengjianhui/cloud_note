package org.tedu.cloudnote.aop;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 切入service 层
 * 
 * 使用异常通知，在发生异常时将异常信息写入文件中保存
 * 		// 将异常信息写入文件 log
 *		try {
 *			
 *		} catch (Exception e) {
 *			// 异常切入点
 *			doException(e);
 *		}
 * @author zjh
 *
 */
@Component
@Aspect	// 将当前组件指定为切面组件
public class ExceptionBean {
	
	// 异常通知 方法有Exception 参数, 该参数为抛出的异常对象
	// throwing 指定异常抛出对应的 该切面方法的参数 是哪一个
	@AfterThrowing(
			throwing="e",
			pointcut="within(org.tedu.cloudnote.service..*)"
			)
	public void doException(Exception e) {
//		System.out.println(e.getMessage());
		
		try {
			FileWriter fw = new FileWriter("/Users/mac/Desktop/error.log",true);
			PrintWriter pw = new PrintWriter(fw);
			
			SimpleDateFormat sdf
				= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			//打印错误标题
			pw.println("************************************");
			pw.println("异常类型:"+ e);
			pw.println("发生时间:" + sdf.format(new Date()));
			pw.println("************************************");
			
			// 将异常的栈信息写入指定文件
			e.printStackTrace(pw);
			pw.println("\n\n");
			
			fw.close();
			pw.close();
		} catch (Exception e2) {
			System.out.println("记录文件异常");
		}
		
	}	
}
