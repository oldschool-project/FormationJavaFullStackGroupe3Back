package com.groupe3.fakeslack.controller;

import com.groupe3.fakeslack.entity.Message;
import com.groupe3.fakeslack.service.IServiceMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private IServiceMessage service;


    @GetMapping("")
    public ResponseEntity<List<Message>> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getById(@PathVariable("id") int id) { return service.getById(id); }

    @PostMapping("")
    public ResponseEntity<String> addMessage(@RequestBody Message message) { return service.create(message); }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMessage(@PathVariable("id") int id) { return service.delete(id); }

    @PutMapping("")
    public ResponseEntity<String> updateMessage(@RequestBody Message message) { return service.update(message); }




}
