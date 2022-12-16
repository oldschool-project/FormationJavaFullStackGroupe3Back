package com.groupe3.fakeslack.controller;

import com.groupe3.fakeslack.entity.Message;
import com.groupe3.fakeslack.service.IServiceMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private IServiceMessage service;


    @GetMapping("")
    public List<Message> getAll() {

        return service.getAll();

    }

    @GetMapping("/{id}")
    public Message getById(@PathVariable("id") int id) {

        return service.getById(id);

    }

    @PostMapping("")
    public void addMessage(@RequestBody Message message) {

        service.create(message);

    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable("id") int id) {

        service.delete(id);

    }

    @PutMapping("")
    public void updateMessage(@RequestBody Message message) {
        
        service.update(message);

    }

}
