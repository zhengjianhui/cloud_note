package org.tedu.cloudnote.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable{
	private String cn_user_id;
	private String cn_user_name;
	private String cn_user_password;
	private String cn_user_token;
	private String cn_user_nick;
	public String getCn_user_id() {
		return cn_user_id;
	}
	public void setCn_user_id(String cnUserId) {
		cn_user_id = cnUserId;
	}
	public String getCn_user_name() {
		return cn_user_name;
	}
	public void setCn_user_name(String cnUserName) {
		cn_user_name = cnUserName;
	}
	public String getCn_user_password() {
		return cn_user_password;
	}
	public void setCn_user_password(String cnUserPassword) {
		cn_user_password = cnUserPassword;
	}
	public String getCn_user_token() {
		return cn_user_token;
	}
	public void setCn_user_token(String cnUserToken) {
		cn_user_token = cnUserToken;
	}
	public String getCn_user_nick() {
		return cn_user_nick;
	}
	public void setCn_user_nick(String cnUserNick) {
		cn_user_nick = cnUserNick;
	}
	
}
