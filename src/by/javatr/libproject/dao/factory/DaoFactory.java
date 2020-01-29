package by.javatr.libproject.dao.factory;

import by.javatr.libproject.dao.impl.BookDaoImpl;
import by.javatr.libproject.dao.impl.UserDaoImpl;

public class DaoFactory implements Factory{

    public DaoFactory() {
    }

    @Override
    public UserDaoImpl getUserDAO(String path) {
        return new UserDaoImpl(path);
    }

    @Override
    public BookDaoImpl getBookDAO(String path) {
        return new BookDaoImpl(path);
    }
}
