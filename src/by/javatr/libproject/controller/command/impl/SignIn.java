package by.javatr.libproject.controller.command.impl;

import by.javatr.libproject.controller.command.Command;
import by.javatr.libproject.dao.DaoFactory;
import by.javatr.libproject.dao.impl.UserDaoImpl;
import by.javatr.libproject.service.ServiceFactory;
import by.javatr.libproject.service.UserService;
import by.javatr.libproject.service.exception.ServiceException;

import java.io.IOException;

public class SignIn implements Command {
    @Override
    public String execute(String request) {

        String login = null;
        String password = null;
        String response = "null";

        String[] requestSplit = request.split(";");

        login = requestSplit[0];
        password = requestSplit[1];


        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserService();

        try {
            if (userService.signIn(login, password)) {
                response = "Welcome";
            }
            else response = "invalid login or password";
        } catch (ServiceException e) {
            e.printStackTrace();
        }


        return response;
    }
}
