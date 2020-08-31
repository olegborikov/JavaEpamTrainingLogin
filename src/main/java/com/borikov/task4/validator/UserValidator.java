package com.borikov.task4.validator;

public class UserValidator {
    private static final String LOGIN_REGEX = "^[\\w.]{3,20}$";
    private static final String PASSWORD_REGEX =
            "^(?=.*[\\p{Lower}])(?=.*[\\p{Upper}])(?=.*\\d)[\\p{Alnum}]{8,20}$";

    public boolean isLoginCorrect(String login) {
        boolean result = false;
        if (login != null) {
            result = login.matches(LOGIN_REGEX);
        }
        return result;
    }

    public boolean isPasswordCorrect(String email) {
        boolean result = false;
        if (email != null) {
            result = email.matches(PASSWORD_REGEX);
        }
        return result;
    }
}

