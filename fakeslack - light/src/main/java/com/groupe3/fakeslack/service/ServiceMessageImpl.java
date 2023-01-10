package com.groupe3.fakeslack.service;

import com.groupe3.fakeslack.entity.Channel;
import com.groupe3.fakeslack.entity.Message;
import com.groupe3.fakeslack.entity.User;
import com.groupe3.fakeslack.repository.IMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMessageImpl implements IServiceMessage {


    @Autowired
    private IMessageRepository repository;

/*    @Autowired
    private ServiceUserImpl userService;

    @Autowired
    private ServiceChannelImpl channelService;*/

    @Override
    public ResponseEntity<List<Message>> getAll() {

        return ResponseEntity.ok(repository.findAll());

    }

    @Override
    public ResponseEntity<Message> getById(int id) {

        return ResponseEntity.ok(repository.findById(id).orElse(null));

    }

    @Override
    public ResponseEntity<List<Message>> findByChannelId(int id) {
        List<Message> messages = repository.findByChannelId(id);
        if (messages.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(messages);
    }

    @Override
    public ResponseEntity<List<Message>> findByUserId(int id) {
        List<Message> messages = repository.findByUserId(id);
        if (messages.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(messages);
    }

/*    @Override
    public ResponseEntity<User> getUserForMessage(int id) {

        Message message = repository.findById(id).orElse(null);
        if (message == null) {
            return ResponseEntity.notFound().build();
        }
        return userService.getById(message.getUser().getId());
    }

    @Override
    public ResponseEntity<Channel> getChannelForMessage(int id) {

        Message message = repository.findById(id).orElse(null);
        if (message == null) {
            return ResponseEntity.notFound().build();
        }
        return channelService.getById(message.getChannel().getId());
    }*/


    @Override
    public ResponseEntity<String> create(Message message) {

        repository.save(message);
        return ResponseEntity.ok("Message created successfully");

    }

    @Override
    public ResponseEntity<String> update(Message message) {
        if (!repository.existsById(message.getId())) {
            return ResponseEntity.badRequest().body("An user with the specified id does not exist");
        }
        repository.save(message);
        return ResponseEntity.ok("Message updated successfully");

    }

    @Override
    public ResponseEntity<String> delete(int id) {

        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
        } else {
            return ResponseEntity.badRequest().body("Message does not deleted because message does not exist or not found");
        }
        return ResponseEntity.ok("Message deleted successfully");

    }
}
