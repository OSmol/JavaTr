package by.javatr.libproject.dao.factory;

import by.javatr.libproject.dao.BookDAO;
import by.javatr.libproject.dao.UserDAO;
import by.javatr.libproject.dao.impl.BookDaoImpl;
import by.javatr.libproject.dao.impl.UserDaoImpl;

public interface Factory {
    UserDAO getUserDAO(String path);

    BookDAO getBookDAO(String path);
}
