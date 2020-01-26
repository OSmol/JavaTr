package by.javatr.libproject.controller.command.impl;

import by.javatr.libproject.controller.command.Command;
import by.javatr.libproject.dao.DaoFactory;
import by.javatr.libproject.dao.impl.BookDaoImpl;
import by.javatr.libproject.service.BookService;
import by.javatr.libproject.service.ServiceFactory;
import by.javatr.libproject.service.exception.ServiceException;

import java.io.IOException;

public class DeleteBook implements Command {
    @Override
    public String execute(String request) {
        String response = null;
        int id = Integer.parseInt(request.substring(0,request.length()-1));

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookService bookService = serviceFactory.getBookService();

        try {
            bookService.deleteBook(id);
            response = "Book deleted";
        } catch (ServiceException e) {
            e.printStackTrace();
        }


        return response;
    }
}
