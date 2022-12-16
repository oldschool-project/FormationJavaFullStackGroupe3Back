package com.groupe3.fakeslack.service;

import com.groupe3.fakeslack.entity.Channel;
import java.util.List;
import org.springframework.stereotype.Service;



public interface IServiceChannel {

    public List<Channel> getAll();
    public Channel getById(int id);
    public String create(Channel channel);
    public String delete(int id);
    public String update(Channel channel);
}
