package by.javatr.libproject.service;

import by.javatr.libproject.dao.DaoFactory;
import by.javatr.libproject.dao.exception.DAOException;
import by.javatr.libproject.dao.impl.UserDaoImpl;
import by.javatr.libproject.entity.User;
import by.javatr.libproject.service.exception.ServiceException;

import java.util.List;

public class Validator {

    public boolean userExist(String name) throws ServiceException {

        DaoFactory daoFactory = new DaoFactory();
        UserDaoImpl userDao = (UserDaoImpl) daoFactory.getUserDAO("UserFile.txt");
        List<User> userList = null;

        try {
            userList = userDao.getAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        for (User item:userList) {
                if (item.getName().toUpperCase().equals(name.toUpperCase())) return true;
            }
            return false;
    }

}
