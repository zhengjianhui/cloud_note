package org.tedu.cloudnote.entity;

import java.io.Serializable;

/**
 * 分享笔记实体类
 * @author zjh
 *
 */
@SuppressWarnings("serial")
public class Share implements Serializable{

	// 主键id
	private String cn_share_id;
	// 分享名
	private String cn_share_title;
	// 分享内容
	private String cn_share_body;
	// 笔记本id
	private String cn_note_id;
	
	
	public String getCn_share_id() {
		return cn_share_id;
	}
	public void setCn_share_id(String cnShareId) {
		cn_share_id = cnShareId;
	}
	public String getCn_share_title() {
		return cn_share_title;
	}
	public void setCn_share_title(String cnShareTitle) {
		cn_share_title = cnShareTitle;
	}
	public String getCn_share_body() {
		return cn_share_body;
	}
	public void setCn_share_body(String cnShareBody) {
		cn_share_body = cnShareBody;
	}
	public String getCn_note_id() {
		return cn_note_id;
	}
	public void setCn_note_id(String cnNoteId) {
		cn_note_id = cnNoteId;
	}
	
}
