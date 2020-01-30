package by.javatr.libproject.service;

import by.javatr.libproject.bean.User;
import by.javatr.libproject.service.exception.ServiceException;

public interface UserService {
    boolean signIn(String login, String password) throws ServiceException;

    void registration(User user) throws ServiceException;
}
