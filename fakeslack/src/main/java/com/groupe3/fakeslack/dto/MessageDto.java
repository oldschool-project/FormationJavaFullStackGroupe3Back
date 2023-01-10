package com.groupe3.fakeslack.dto;

import java.util.Date;

public class MessageDto {

    private int id;
    private String text;
    private int channelId;
    private int userId;
    private Date date;

    public MessageDto() {

    }

    public MessageDto(int id, String text, int channelId, int userId, Date date) {
        this.id = id;
        this.text = text;
        this.channelId = channelId;
        this.userId = userId;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
