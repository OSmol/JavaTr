package by.javatr.libproject.controller.command.impl;

import by.javatr.libproject.controller.command.Command;
import by.javatr.libproject.entity.Author;
import by.javatr.libproject.entity.Book;
import by.javatr.libproject.service.ServiceFactory;
import by.javatr.libproject.service.exception.ServiceException;
import by.javatr.libproject.service.impl.BookServiceImpl;

public class AddBook implements Command {
    @Override
    public String execute(String request) {

        String login = null;
        String name = null;
        Author author = null;

        int id = 0;
        int publish = 0;

        String response = null;

        String[] requestSplit = request.split(";");

        try {
            id = Integer.parseInt(requestSplit[0]);
            name = requestSplit[1];
            author = new Author(requestSplit[2]);
            publish = Integer.parseInt(requestSplit[3]);
        } catch (IndexOutOfBoundsException e) {
            return "invalid input parameters";
        }


        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookServiceImpl bookServiceImpl = serviceFactory.getBookService();

        try {
            bookServiceImpl.addBook(new Book(id, name, author, publish));
            response = "Книга " + name + " добавлена";

        } catch (ServiceException e) {
            response = e.getMessage();
        }


        return response;
    }
}
