package by.javatr.libproject.controller.command.impl;

import by.javatr.libproject.bean.User;
import by.javatr.libproject.controller.command.Command;
import by.javatr.libproject.service.UserService;
import by.javatr.libproject.service.exception.ServiceException;
import by.javatr.libproject.service.factory.ServiceFactory;

public class Registration implements Command {
    @Override
    public String execute(String request) {
        String login = null;
        String password = null;
        String response = "null";

        String[] requestSplit = request.split(";");

        if (!checkSize(requestSplit, 2)) {
            return "invalid input parameters";
        }

        login = requestSplit[0];
        password = requestSplit[1];


        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userServiceImpl = serviceFactory.getUserService();

        try {
            userServiceImpl.registration(new User(login, password));
            response = "welcome, you are registered as " + login;
        } catch (ServiceException e) {
            response = e.getMessage();// никогда во view не отправляй сообщения подсистемы работы с исключениями
            //. не окрывай свои секреты)))
        }


        return response;
    }
}
