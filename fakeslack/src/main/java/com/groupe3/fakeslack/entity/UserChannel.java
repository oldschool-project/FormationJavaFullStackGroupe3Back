package com.groupe3.fakeslack.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_channels")
public class UserChannel {

    @Id
    private int userId;

    private int channelId;

    public UserChannel() {
    }

    public UserChannel(int userId, int channelId) {
        this.userId = userId;
        this.channelId = channelId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }
}
