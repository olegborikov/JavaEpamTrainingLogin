package com.borikov.task4.controller.command;

import com.borikov.task4.controller.command.impl.LoginCommand;
import com.borikov.task4.controller.command.impl.LogoutCommand;

public enum CommandType {
    LOGIN_COMMAND(new LoginCommand()),
    LOGOUT_COMMAND(new LogoutCommand());

    private final Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
