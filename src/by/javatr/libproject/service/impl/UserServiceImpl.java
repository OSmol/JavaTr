package by.javatr.libproject.service.impl;

import by.javatr.libproject.dao.factory.DaoFactory;
import by.javatr.libproject.dao.exception.DAOException;
import by.javatr.libproject.dao.impl.UserDaoImpl;
import by.javatr.libproject.entity.User;
import by.javatr.libproject.service.UserService;
import by.javatr.libproject.service.exception.ServiceException;
import by.javatr.libproject.service.exception.UserExistException;
import by.javatr.libproject.service.impl.validator.Validator;
import by.javatr.libproject.service.impl.validator.impl.UserExistValidator;

public class UserServiceImpl implements UserService {

    private final DaoFactory daoFactory = new DaoFactory();
    private final UserDaoImpl userDao = daoFactory.getUserDAO("UserFile.txt");

    @Override
    public boolean signIn(String login, String password) throws ServiceException {
        try {
            return userDao.signIn(login, password);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }

    @Override
    public void registration(User user) throws ServiceException {
        if (new UserExistValidator().validate(user.getName()))
            throw new UserExistException("User " + user.getName() + " Exist!");
        try {
            userDao.registration(user);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
