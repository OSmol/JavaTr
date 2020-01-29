package by.javatr.libproject.dao.factory;

import by.javatr.libproject.dao.impl.BookDaoImpl;
import by.javatr.libproject.dao.impl.UserDaoImpl;

public interface Factory {
    UserDaoImpl getUserDAO(String path);

    BookDaoImpl getBookDAO(String path);
}
