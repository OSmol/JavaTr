package by.javatr.libproject.service.factory;

import by.javatr.libproject.service.BookService;
import by.javatr.libproject.service.UserService;
import by.javatr.libproject.service.impl.BookServiceImpl;
import by.javatr.libproject.service.impl.UserServiceImpl;

public class ServiceFactory implements Factory {

    private final UserService userService = new UserServiceImpl();
    private final BookService bookService = new BookServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return ServiceFactoryHolder.instance;
    }

    @Override
    public UserService getUserService() {
        return userService;
    }

    @Override
    public BookService getBookService() {
        return bookService;
    }

    private static class ServiceFactoryHolder {
        private final static ServiceFactory instance = new ServiceFactory();
    }
}
