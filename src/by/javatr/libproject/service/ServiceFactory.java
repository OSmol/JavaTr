package by.javatr.libproject.service;

public class ServiceFactory {
    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return ServiceFactoryHolder.instance;
    }

    public UserService getUserService() {
        return new UserService();
    }

    public BookService getBookService() {
        return new BookService();
    }

    private static class ServiceFactoryHolder {
        private final static ServiceFactory instance = new ServiceFactory();
    }
}
