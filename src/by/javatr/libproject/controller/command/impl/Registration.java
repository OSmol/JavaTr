package by.javatr.libproject.controller.command.impl;

import by.javatr.libproject.controller.command.Command;
import by.javatr.libproject.entity.User;
import by.javatr.libproject.service.ServiceFactory;
import by.javatr.libproject.service.exception.ServiceException;
import by.javatr.libproject.service.impl.UserServiceImpl;

public class Registration implements Command {
    @Override
    public String execute(String request) {
        String login = null;
        String password = null;
        String response = "null";

        String[] requestSplit = request.split(";");

        try {
            login = requestSplit[0];
            password = requestSplit[1];
        } catch (IndexOutOfBoundsException e) {
            return "invalid input parameters";
        }

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserServiceImpl userServiceImpl = serviceFactory.getUserService();

        try {
            userServiceImpl.registration(new User(login, password));
            response = "welcome, you are registered as " + login;
        } catch (ServiceException e) {
            response = e.getMessage();
        }


        return response;
    }
}
