package com.groupe3.fakeslack.service;

import com.groupe3.fakeslack.entity.Channel;
import com.groupe3.fakeslack.repository.IChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceChannelImpl implements IServiceChannel {

    @Autowired
    private IChannelRepository repository;

    @Override
    public List<Channel> getAll() {
        return repository.findAll();
    }

    @Override
    public Channel getById(Integer id) {
        return repository.findById(id).get();

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
        repository.save(channel);
        return "Channel created!";
    }

    @Override
    public String delete(Integer id) {
        repository.delete(getById(id));
        return "Channel deleted!";
    }

    @Override
    public String update(Channel channel) {
        Channel channelToUpdate = getById(channel.getId());
        channelToUpdate.setName(channel.getName());
        repository.save(channelToUpdate);
        return "Channel updated!";
    }
}
