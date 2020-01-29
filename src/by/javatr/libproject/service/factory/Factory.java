package by.javatr.libproject.service.factory;

import by.javatr.libproject.service.impl.BookServiceImpl;
import by.javatr.libproject.service.impl.UserServiceImpl;

public interface Factory {
    UserServiceImpl getUserService();

    BookServiceImpl getBookService();
}
