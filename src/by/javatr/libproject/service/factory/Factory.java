package by.javatr.libproject.service.factory;

import by.javatr.libproject.service.BookService;
import by.javatr.libproject.service.UserService;
import by.javatr.libproject.service.impl.BookServiceImpl;
import by.javatr.libproject.service.impl.UserServiceImpl;

public interface Factory {
    UserService getUserService();

    BookService getBookService();
}
