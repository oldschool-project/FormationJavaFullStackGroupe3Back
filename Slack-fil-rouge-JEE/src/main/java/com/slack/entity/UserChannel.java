package com.slack.entity;

public class UserChannel {
	private int channelId;
	private int userId;

	public UserChannel(int channelId, int userId) {
		super();
		this.channelId = channelId;
		this.userId = userId;
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

}
