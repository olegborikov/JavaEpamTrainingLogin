package com.borikov.task4.controller.command.impl;

import com.borikov.task4.controller.PagePath;
import com.borikov.task4.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return PagePath.LOGIN;
    }
}
