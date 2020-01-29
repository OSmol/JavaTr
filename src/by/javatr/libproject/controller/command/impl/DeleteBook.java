package by.javatr.libproject.controller.command.impl;

import by.javatr.libproject.controller.command.Command;
import by.javatr.libproject.service.BookService;
import by.javatr.libproject.service.exception.ServiceException;
import by.javatr.libproject.service.factory.ServiceFactory;

public class DeleteBook implements Command {
    @Override
    public String execute(String request) {
        String response = null;
        int id = Integer.parseInt(request);

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookService bookServiceImpl = serviceFactory.getBookService();

        try {
            bookServiceImpl.deleteBook(id);
            response = "Book deleted";
        } catch (ServiceException e) {
            response = e.getMessage();
        }


        return response;
    }
}
