package by.javatr.libproject.service;

import by.javatr.libproject.dao.DaoFactory;
import by.javatr.libproject.dao.LibraryDAO;
import by.javatr.libproject.dao.exception.DAOException;
import by.javatr.libproject.dao.impl.UserDaoImpl;
import by.javatr.libproject.entity.User;
import by.javatr.libproject.service.exception.ServiceException;
import by.javatr.libproject.service.exception.UserExistException;

public class UserService {

    private static final DaoFactory daoFactory = new DaoFactory();
    private static final UserDaoImpl userDao = daoFactory.getUserDAO("UserFile.txt");

    public boolean signIn(String login, String password) throws ServiceException {
        try {
            return userDao.signIn(login,password);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }

    public void registration(User user) throws ServiceException {
        if (new Validator().userExist(user.getName())) throw new UserExistException("User "+user.getName()+" Exist!");
        try {
            userDao.add(user);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
