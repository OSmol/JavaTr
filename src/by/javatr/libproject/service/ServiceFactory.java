package by.javatr.libproject.service;

import by.javatr.libproject.service.impl.BookServiceImpl;
import by.javatr.libproject.service.impl.UserServiceImpl;

public class ServiceFactory {
    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return ServiceFactoryHolder.instance;
    }

    public UserServiceImpl getUserService() {
        return new UserServiceImpl();
    }

    public BookServiceImpl getBookService() {
        return new BookServiceImpl();
    }

    private static class ServiceFactoryHolder {
        private final static ServiceFactory instance = new ServiceFactory();
    }
}
