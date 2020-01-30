package by.javatr.libproject.dao;

import by.javatr.libproject.dao.exception.DAOException;
import by.javatr.libproject.bean.User;

import java.util.List;

public interface UserDAO {

    User findByName(String login) throws DAOException;

    void registration(User user) throws DAOException;

    List<User> getAll() throws DAOException;
}
