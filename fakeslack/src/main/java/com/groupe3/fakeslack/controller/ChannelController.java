package com.groupe3.fakeslack.controller;

import com.groupe3.fakeslack.entity.Channel;
import com.groupe3.fakeslack.service.IServiceChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class ChannelController {

    @Autowired
    private IServiceChannel service;

    @GetMapping("")
    public List<Channel> getAll() {
        return null;
    }

    @GetMapping("/{id}")
    public Channel getById(@PathVariable("id") int id) {

        return null;
    }

    @PostMapping("")
    public void addChannel(@RequestBody Channel channel) {

    }

    @DeleteMapping("/{id}")
    public void deleteChannel(@PathVariable("id") int id) {

    }

    @PutMapping("")
    public void updateChannel(@RequestBody Channel channel) {

    }
}
