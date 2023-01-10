package com.groupe3.fakeslack.repository;

import com.groupe3.fakeslack.entity.Channel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IChannelRepository extends JpaRepository<Channel, Integer> {
    Channel findByName(String name);
    Channel findByMessage_id(int messageId);
    List<Channel> findByUser_id(int userId);

}
