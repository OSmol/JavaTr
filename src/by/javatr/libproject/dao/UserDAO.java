package by.javatr.libproject.dao;

import by.javatr.libproject.dao.exception.DAOException;
import by.javatr.libproject.entity.User;

public interface UserDAO {

    boolean signIn(String login, String password) throws DAOException;

    void registration(User user) throws DAOException;
}
