package org.tedu.cloudnote.util;


import java.security.MessageDigest;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;




/**
 * MD5 不可逆散列算法 
 * @author zjh
 *
 */
public class NoteUtil {
	
	/**
	 * 采用UUID算法生成一个唯一性的字符串
	 * @return 主键值id
	 */
	public static String createId(){
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();
		return id;
	}
	
	public static String md5(String msg){
		try{
			MessageDigest md5 = 
				MessageDigest.getInstance("MD5");
			//原始信息input 获取二进制信息
			byte[] input = msg.getBytes();
			//加密信息output
			byte[] output = md5.digest(input);//加密处理
			//采用Base64将加密内容output转成String字符串
			String s = Base64.encodeBase64String(output);
			return s;
		}catch(Exception ex){
			System.out.println("md5加密失败");
			return null;
		}
	}
	
	/**
	 * MD5转换过程
	 * @param msg
	 * @return
	 */
	public static String md5Parse(String msg) {
		
		// 首先初始化一个字符数组，用来存放每个16进制字符
		char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9', 'A','B','C','D','E','F' };
		  
		try {
			  MessageDigest md = 
					MessageDigest.getInstance("MD5");
			  //原始信息input
			  byte[] input = msg.getBytes();
			  //加密信息output
			  byte[] output = md.digest(input);//加密处理
		  
			  // new一个字符数组，这个就是用来组成结果字符串的
			  //（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））
			  char[] resultCharArray =new char[output.length * 2];
	
			  // 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去
			  int index = 0;
			  for (byte b : output) {
			     resultCharArray[index++] = hexDigits[b>>> 4 & 0xf];
			     resultCharArray[index++] = hexDigits[b& 0xf];
			  }
	
			  // 字符数组组合成字符串返回
			  return new String(resultCharArray);
		} catch (Exception e) {
			
		}
		return msg;
	}
	
	public static void main(String[] args) {
		String s = md5("123789");
		String s1 = md5Parse("123789");
		System.out.println(s);
		System.out.println(s1);
		System.out.println(Base64.encodeBase64String(s1.getBytes()));
	}
	
}
