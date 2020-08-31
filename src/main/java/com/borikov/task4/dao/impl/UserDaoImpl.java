package com.borikov.task4.dao.impl;

import com.borikov.task4.dao.ColumnName;
import com.borikov.task4.dao.UserDao;
import com.borikov.task4.dao.pool.ConnectionPool;
import com.borikov.task4.entity.User;
import com.borikov.task4.exception.DaoException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String FIND_USER_BY_LOGIN = "SELECT user_id, login, " +
            "password FROM user WHERE login LIKE ?";

    @Override
    public Optional<User> findByLogin(String login) throws DaoException {
        ResultSet resultSet = null;
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(FIND_USER_BY_LOGIN)) {
            statement.setString(1, login);
            resultSet = statement.executeQuery();
            Optional<User> userOptional = Optional.empty();
            if (resultSet.next()) {
                User user = createUserFromResultSet(resultSet);
                userOptional = Optional.of(user);
            }
            return userOptional;
        } catch (SQLException e) {
            throw new DaoException("Finding user by login error", e);
        } finally {
            closeResultSet(resultSet);
        }
    }

    private void closeResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            LOGGER.log(Level.ERROR, "Error while closing resultSet");
        }
    }

    private User createUserFromResultSet(ResultSet resultSet) throws SQLException {
        long userId = resultSet.getLong(ColumnName.USER_ID);
        String login = resultSet.getString(ColumnName.LOGIN);
        String password = resultSet.getString(ColumnName.PASSWORD);
        User user = new User(userId, login, password);
        return user;
    }
}
