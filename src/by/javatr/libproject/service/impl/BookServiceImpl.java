package by.javatr.libproject.service.impl;

import by.javatr.libproject.dao.DaoFactory;
import by.javatr.libproject.dao.exception.DAOException;
import by.javatr.libproject.dao.impl.BookDaoImpl;
import by.javatr.libproject.entity.Book;
import by.javatr.libproject.service.BookService;
import by.javatr.libproject.service.exception.BookIDExistException;
import by.javatr.libproject.service.exception.ServiceException;
import by.javatr.libproject.service.impl.validator.Validator;

import java.util.List;

public class BookServiceImpl implements BookService {

    private final DaoFactory daoFactory = new DaoFactory();
    private final BookDaoImpl bookDao = daoFactory.getBookDAO("BookFile.txt");

    @Override
    public void addBook(Book book) throws ServiceException {
        if (new Validator().isBookIdExist(book.getId()))
            throw new BookIDExistException("Book with " + (book.getId()) + "exist!");
        try {
            bookDao.addBook(book);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteBook(int id) throws ServiceException {
        try {
            bookDao.deleteBook(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Book> findAll() throws ServiceException {
        try {
            return bookDao.getAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Book findByName(String name) throws ServiceException {
        try {
            return bookDao.findByName(name);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
