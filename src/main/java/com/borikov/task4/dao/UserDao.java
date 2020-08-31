package com.borikov.task4.dao;

import com.borikov.task4.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<User> findAll();

    Optional<User> findByLoginAndPassword(String login, String password);
}
