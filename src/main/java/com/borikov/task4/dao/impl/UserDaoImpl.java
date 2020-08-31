package com.borikov.task4.dao.impl;

import com.borikov.task4.dao.UserDao;
import com.borikov.task4.entity.User;

import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findByLoginAndPassword(String login, String password) {
        return Optional.empty();
    }
}
