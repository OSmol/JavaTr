package by.javatr.libproject.dao;

import by.javatr.libproject.dao.impl.BookDaoImpl;
import by.javatr.libproject.dao.impl.UserDaoImpl;

public class DaoFactory {
    public DaoFactory() {
    }

    public UserDaoImpl getUserDAO(String path) {
        return new UserDaoImpl(path);
    }

    public BookDaoImpl getBookDAO(String path) {
        return new BookDaoImpl(path);
    }

}
