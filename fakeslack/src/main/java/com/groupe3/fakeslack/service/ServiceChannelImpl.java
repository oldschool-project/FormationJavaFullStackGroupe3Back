package com.groupe3.fakeslack.service;

import com.groupe3.fakeslack.entity.Channel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceChannelImpl implements IServiceChannel {
    @Override
    public List<Channel> getAll() {
        return null;
    }

    @Override
    public Channel getById(int id) {
        return null;
    }

    @Override
    public String create(Channel channel) {
        return null;
    }

    @Override
    public String delete(int id) {
        return null;
    }

    @Override
    public String update(Channel channel) {
        return null;
    }
}
