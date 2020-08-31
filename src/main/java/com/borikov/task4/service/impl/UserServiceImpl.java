package com.borikov.task4.service.impl;

import com.borikov.task4.dao.UserDao;
import com.borikov.task4.dao.impl.UserDaoImpl;
import com.borikov.task4.entity.User;
import com.borikov.task4.exception.DaoException;
import com.borikov.task4.exception.ServiceException;
import com.borikov.task4.service.UserService;
import com.borikov.task4.validator.UserValidator;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Override
    public boolean isUserExists(String login, String password) throws ServiceException {
        try {
            UserValidator userValidator = new UserValidator();
            UserDao userDao = new UserDaoImpl();
            boolean result = false;
            if (userValidator.isLoginCorrect(login)
                    && userValidator.isPasswordCorrect(password)) {
                Optional<User> userOptional = userDao.findByLogin(login);
                if (userOptional.isPresent()) {
                    User user = userOptional.get();
                    result = user.getLogin().equals(login)
                            && user.getPassword().equals(password);
                }
            }
            return result;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
