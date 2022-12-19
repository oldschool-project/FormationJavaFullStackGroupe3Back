package com.groupe3.fakeslack.service;

import com.groupe3.fakeslack.entity.User;
import org.springframework.http.ResponseEntity;

public interface IServiceUser {
    public ResponseEntity<?> getAll();
    public ResponseEntity<?> getById(int id);
    public ResponseEntity<String> create(User user);
    public ResponseEntity<String> delete(int id);
    public ResponseEntity<String> update(User user);
}
