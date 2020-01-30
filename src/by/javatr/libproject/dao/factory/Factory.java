package by.javatr.libproject.dao.factory;

import by.javatr.libproject.dao.BookDAO;
import by.javatr.libproject.dao.UserDAO;

public interface Factory {
    UserDAO getUserDAO();

    BookDAO getBookDAO();
}
