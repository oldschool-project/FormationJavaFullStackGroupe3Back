package com.groupe3.fakeslack.service;

import com.groupe3.fakeslack.entity.Message;

import java.util.List;

public interface IServiceMessage {

    public List<Message> getAll();
    public Message getById(Integer id);
    public String create(Message message);
    public String update(Message message);
    public String delete(int id);
}
