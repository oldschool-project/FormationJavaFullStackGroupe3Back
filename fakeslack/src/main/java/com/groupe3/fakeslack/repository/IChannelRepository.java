package com.groupe3.fakeslack.repository;

import com.groupe3.fakeslack.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IChannelRepository extends JpaRepository<Channel, Integer> {
}
