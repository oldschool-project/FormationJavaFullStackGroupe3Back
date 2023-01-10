package com.groupe3.fakeslack.repository;

import com.groupe3.fakeslack.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IMessageRepository extends JpaRepository<Message, Integer> {
}
