package com.groupe3.fakeslack.service;

import com.groupe3.fakeslack.entity.Message;
import com.groupe3.fakeslack.repository.IMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMessageImpl implements IServiceMessage{


    @Autowired
    private IMessageRepository repository;

    @Override
    public List<Message> getAll() {
        return repository.findAll();
    }

    @Override
    public Message getById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public String create(Message message) {
        repository.save(message);
        return "message créée";
    }

    @Override
    public String update(Message message) {

        Message messageUpdate = getById(message.getId());

        messageUpdate.setText(message.getText());
        repository.save(messageUpdate);
        return "message modifié";
    }

    @Override
    public String delete(int id) {

        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
        } else {
            return "This message is not delete";
        }
        return "This message is delete";
    }

    public IMessageRepository getRepository() {
        return repository;
    }

    public void setRepository(IMessageRepository repository) {
        this.repository = repository;
    }
}
