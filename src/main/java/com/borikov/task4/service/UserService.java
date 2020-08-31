package com.borikov.task4.service;

import com.borikov.task4.exception.ServiceException;

public interface UserService {
    boolean isUserExists(String login, String password) throws ServiceException;
}
