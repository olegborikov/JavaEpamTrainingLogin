package com.borikov.task4.controller.command.impl;

import com.borikov.task4.controller.PagePath;
import com.borikov.task4.controller.RequestParameter;
import com.borikov.task4.controller.command.Command;
import com.borikov.task4.exception.ServiceException;
import com.borikov.task4.service.UserService;
import com.borikov.task4.service.impl.UserServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final UserService userService = new UserServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String login = request.getParameter(RequestParameter.LOGIN);
        String password = request.getParameter(RequestParameter.PASSWORD);
        try {
            if (userService.isUserExists(login, password)) {
                page = PagePath.MAIN;
            } else {
                request.setAttribute(RequestParameter.ERROR_LOGIN_PASSWORD_MESSAGE,
                        "Incorrect login or password");
                page = PagePath.LOGIN;
            }
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, "Error while login user", e);
            request.setAttribute(RequestParameter.ERROR_MESSAGE, e);
            page = PagePath.ERROR;
        }
        return page;
    }
}
