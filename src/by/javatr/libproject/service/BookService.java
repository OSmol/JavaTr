package by.javatr.libproject.service;

import by.javatr.libproject.entity.Book;
import by.javatr.libproject.service.exception.ServiceException;

import java.util.List;

public interface BookService {
    void addBook(Book book) throws ServiceException;

    void deleteBook(int id) throws ServiceException;

    List<Book> findAll() throws ServiceException;

    Book findByName(String name) throws ServiceException;
}
