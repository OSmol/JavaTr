package by.javatr.libproject.controller.command.impl;

import by.javatr.libproject.bean.Book;
import by.javatr.libproject.controller.command.Command;
import by.javatr.libproject.service.BookService;
import by.javatr.libproject.service.exception.ServiceException;
import by.javatr.libproject.service.factory.ServiceFactory;

public class ShowBook implements Command {
    @Override
    public String execute(String request) {
        String response = null;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookService bookService = serviceFactory.getBookService();

        if ((request.isEmpty()) || (request == null)) {

            StringBuilder sb = new StringBuilder();

            try {
                for (Book item : bookService.findAll()) {
                    sb.append(item.toString());
                    sb.append('\n');
                    response = sb.toString();
                }
            } catch (ServiceException e) {
                response = e.getMessage();
            }

        } else {

            try {
                response = bookService.findByName(request).toString();
            } catch (ServiceException e) {
                response = e.getMessage();
            }

        }
        return response;
    }

}
