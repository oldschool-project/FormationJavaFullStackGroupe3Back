package com.groupe3.fakeslack.dto;

import java.util.Date;

public class MessageDto {

    private int id;
    private String content;
    private String username;
    private Date date;

    public MessageDto(int id, String content, String username, Date date) {
        this.id = id;
        this.content = content;
        this.username = username;
        this.date = date;
    }

    public MessageDto() {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
