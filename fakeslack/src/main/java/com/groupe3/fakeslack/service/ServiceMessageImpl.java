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

        return repository.findById(id).orElse(null);

    }

    @Override
    public String create(Message message) {

        if(repository.save(message) != null) {
            return "Message created successfully";
        } else {
            return "Message does not created";
        }

    }

    @Override
    public String update(Message message) {

        Message messageUpdate = getById(message.getId());
        messageUpdate.setText(message.getText());

        repository.save(messageUpdate);
        return "Message updated successfully";

    }

    @Override
    public String delete(int id) {

        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
        } else {
            return "Message does not deleted because message does not exist or not found";
        }
        return "Message deleted successfully";

    }

    public IMessageRepository getRepository() {

        return repository;

    }

    public void setRepository(IMessageRepository repository) {

        this.repository = repository;

    }
}
