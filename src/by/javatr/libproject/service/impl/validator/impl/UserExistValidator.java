package by.javatr.libproject.service.impl.validator.impl;

import by.javatr.libproject.dao.exception.DAOException;
import by.javatr.libproject.dao.factory.DaoFactory;
import by.javatr.libproject.dao.impl.UserDaoImpl;
import by.javatr.libproject.entity.User;
import by.javatr.libproject.service.exception.ServiceException;
import by.javatr.libproject.service.impl.validator.Validator;

import java.util.List;

public class UserExistValidator implements Validator<String> {

    @Override
    public boolean validate(String field) throws ServiceException {

        DaoFactory daoFactory = new DaoFactory();
        UserDaoImpl userDao = daoFactory.getUserDAO("UserFile.txt");
        List<User> userList = null;

        try {
            userList = userDao.getAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        for (User item : userList) {
            if (item.getName().toUpperCase().equals(field.toUpperCase())) return true;
        }
        return false;
    }
}
