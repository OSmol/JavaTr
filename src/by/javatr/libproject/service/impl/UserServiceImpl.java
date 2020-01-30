package by.javatr.libproject.service.impl;

import by.javatr.libproject.dao.UserDAO;
import by.javatr.libproject.dao.exception.DAOException;
import by.javatr.libproject.dao.factory.DaoFactory;
import by.javatr.libproject.bean.User;
import by.javatr.libproject.service.UserService;
import by.javatr.libproject.service.exception.InvalidLoginException;
import by.javatr.libproject.service.exception.InvalidPasswordException;
import by.javatr.libproject.service.exception.ServiceException;
import by.javatr.libproject.service.exception.UserExistException;
import by.javatr.libproject.service.validator.UserValidator;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final DaoFactory daoFactory = DaoFactory.getInstance();
    private final UserDAO userDao = daoFactory.getUserDAO();

    @Override
    public boolean signIn(String login, String password) throws ServiceException {
        try {
            User user = userDao.findByName(login);
            return (user.getName().equals(login)) && (user.getPassword().equals(password));
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }

    @Override
    public void registration(User user) throws ServiceException {
        if (!UserValidator.validateLogin(user.getName())) throw new InvalidLoginException("login is incorrect");
        if (!UserValidator.validatePassword(user.getPassword())) throw new InvalidPasswordException("password is incorrect");
        if (isUserExist(user.getName())) throw new UserExistException("User " + user.getName() + " Exist!");

        try {
            userDao.registration(user);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public boolean isUserExist(String field) throws ServiceException {

        List<User> userList = null;

        try {
            userList = userDao.getAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        for (User item : userList) {
            if (item.getName().equalsIgnoreCase(field)) return true;
        }
        return false;
    }


}
