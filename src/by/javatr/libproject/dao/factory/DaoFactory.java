package by.javatr.libproject.dao.factory;

import by.javatr.libproject.dao.BookDAO;
import by.javatr.libproject.dao.UserDAO;
import by.javatr.libproject.dao.impl.BookDaoImpl;
import by.javatr.libproject.dao.impl.UserDaoImpl;

public class DaoFactory implements Factory {

    private static class DAOFactoryHolder {
        private final static DaoFactory instance = new DaoFactory();
    }

    public static DaoFactory getInstance() {
        return DAOFactoryHolder.instance;
    }

    public DaoFactory() {
    }

    @Override
    public UserDAO getUserDAO() {
        return new UserDaoImpl();
    }

    @Override
    public BookDAO getBookDAO() {
        return new BookDaoImpl();
    }
}
