package com.groupe3.fakeslack.repository;

import com.groupe3.fakeslack.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    User findByName(String name);
}
