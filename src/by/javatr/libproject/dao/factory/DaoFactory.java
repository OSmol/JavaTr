package by.javatr.libproject.dao.factory;

import by.javatr.libproject.dao.BookDAO;
import by.javatr.libproject.dao.UserDAO;
import by.javatr.libproject.dao.impl.BookDaoImpl;
import by.javatr.libproject.dao.impl.UserDaoImpl;

public class DaoFactory implements Factory {

    public DaoFactory() {
    }

    @Override
    public UserDAO getUserDAO(String path) {
        return new UserDaoImpl(path);
    }

    @Override
    public BookDAO getBookDAO(String path) {
        return new BookDaoImpl(path);
    }
}
