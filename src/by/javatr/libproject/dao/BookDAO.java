package by.javatr.libproject.dao;

import by.javatr.libproject.dao.exception.DAOException;
import by.javatr.libproject.bean.Book;

import java.util.List;

public interface BookDAO {

    void addBook(Book book) throws DAOException;

    void deleteBook(int id) throws DAOException;

    void updateBook(int id, Book book) throws DAOException;

    List<Book> getAll() throws DAOException;

    Book findByName(String name) throws DAOException;

}
