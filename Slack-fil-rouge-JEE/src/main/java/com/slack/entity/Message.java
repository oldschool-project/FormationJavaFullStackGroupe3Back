package com.slack.entity;

import java.util.Date;

public class Message {

	private int id;
	private String content;
	private Date creationDate;
	private Date updateDate;
	private int channelId;
	private int userId;
	private String username;

	public Message(int id, String content, Date creationDate, Date updateDate, int channelId, int userId) {
		super();
		this.id = id;
		this.content = content;
		this.creationDate = creationDate;
		this.updateDate = updateDate;
		this.channelId = channelId;
		this.userId = userId;
	}

	public Message(String content, Date creationDate, Date updateDate, int channelId, int userId) {
		super();
		this.content = content;
		this.creationDate = creationDate;
		this.updateDate = updateDate;
		this.channelId = channelId;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public int getChannelId() {
		return channelId;
	}

	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", content=" + content + ", creationDate=" + creationDate + ", updateDate="
				+ updateDate + ", channelId=" + channelId + ", userId=" + userId + ", username=" + username + "]";
	}

}
