package by.javatr.libproject.service.factory;

import by.javatr.libproject.service.impl.BookServiceImpl;
import by.javatr.libproject.service.impl.UserServiceImpl;

public class ServiceFactory implements Factory {

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return ServiceFactoryHolder.instance;
    }

    @Override
    public UserServiceImpl getUserService() {
        return new UserServiceImpl();
    }

    @Override
    public BookServiceImpl getBookService() {
        return new BookServiceImpl();
    }

    private static class ServiceFactoryHolder {
        private final static ServiceFactory instance = new ServiceFactory();
    }
}
