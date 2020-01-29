package by.javatr.libproject.service.impl.validator;

import by.javatr.libproject.dao.DaoFactory;
import by.javatr.libproject.dao.exception.DAOException;
import by.javatr.libproject.dao.impl.BookDaoImpl;
import by.javatr.libproject.dao.impl.UserDaoImpl;
import by.javatr.libproject.entity.Book;
import by.javatr.libproject.entity.User;
import by.javatr.libproject.service.exception.ServiceException;

import java.util.List;

public class Validator {

    public boolean isUserExist(String name) throws ServiceException {

        DaoFactory daoFactory = new DaoFactory();
        UserDaoImpl userDao = daoFactory.getUserDAO("UserFile.txt");
        List<User> userList = null;

        try {
            userList = userDao.getAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        for (User item : userList) {
            if (item.getName().toUpperCase().equals(name.toUpperCase())) return true;
        }
        return false;
    }

    public boolean isBookIdExist(int id) throws ServiceException {
        DaoFactory daoFactory = new DaoFactory();
        BookDaoImpl bookDao = daoFactory.getBookDAO("BookFile.txt");
        List<Book> bookList = null;

        try {
            bookList = bookDao.getAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        for (Book item : bookList) {
            if (item.getId() == id) return true;
        }
        return false;
    }

}
