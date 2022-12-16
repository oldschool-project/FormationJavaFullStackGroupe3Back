package com.groupe3.fakeslack.controller;

import com.groupe3.fakeslack.entity.Message;
import com.groupe3.fakeslack.service.IServiceMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private IServiceMessage service;


    @GetMapping("")
    public ResponseEntity<List<Message>> getAll() {

        List<Message> messages = service.getAll();

        if(messages == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(messages);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getById(@PathVariable("id") int id) {

        Message message = service.getById(id);

        if(message == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(message);

    }

    @PostMapping("")
    public ResponseEntity<String> addMessage(@RequestBody Message message) {

        String createdMessage = service.create(message);

        return ResponseEntity.ok().body(createdMessage);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMessage(@PathVariable("id") int id) {

        String deletedMessage = service.delete(id);

        return ResponseEntity.ok().body(deletedMessage);

    }

    @PutMapping("")
    public ResponseEntity<String> updateMessage(@RequestBody Message message) {

        String updatedMessage = service.update(message);

        if(updatedMessage == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(updatedMessage);

    }




}
