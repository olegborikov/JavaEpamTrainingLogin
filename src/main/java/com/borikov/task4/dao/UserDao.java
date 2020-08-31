package com.borikov.task4.dao;

import com.borikov.task4.entity.User;
import com.borikov.task4.exception.DaoException;

import java.util.Optional;

public interface UserDao {
    Optional<User> findByLogin(String login) throws DaoException;
}
