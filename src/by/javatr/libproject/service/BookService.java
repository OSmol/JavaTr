package by.javatr.libproject.service;

import by.javatr.libproject.dao.DaoFactory;
import by.javatr.libproject.dao.exception.DAOException;
import by.javatr.libproject.dao.impl.BookDaoImpl;
import by.javatr.libproject.entity.Book;
import by.javatr.libproject.service.exception.ServiceException;

import java.util.List;

public class BookService {

    private static final DaoFactory daoFactory = new DaoFactory();
    private static final BookDaoImpl bookDao = daoFactory.getBookDAO("BookFile.txt");

    public void addBook(Book book) throws ServiceException {
        try {
            bookDao.addBook(book);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }


    public void deleteBook(int id) throws ServiceException {
        try {
            bookDao.deleteBook(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }


    public List<Book> findAll() throws ServiceException {
        try {
            return bookDao.getAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public Book findByName(String name) throws ServiceException {
        try {
            return bookDao.findByName(name);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
