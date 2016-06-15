package org.tedu.cloudnote.util;

import java.io.Serializable;

/**
 * 统一json响应
 * 0成功
 * 1账号错误
 * 2密码错误
 * @author Administrator
 */
@SuppressWarnings("serial")
public class NoteResult implements Serializable{
	private int status;//返回的状态
	private String msg;//返回的消息
	private Object data;//返回的数据
	
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
