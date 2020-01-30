package by.javatr.libproject.service.impl;

import by.javatr.libproject.dao.BookDAO;
import by.javatr.libproject.dao.exception.DAOException;
import by.javatr.libproject.dao.factory.DaoFactory;
import by.javatr.libproject.bean.Book;
import by.javatr.libproject.service.BookService;
import by.javatr.libproject.service.exception.*;
import by.javatr.libproject.service.validator.BookValidator;

import java.util.List;

public class BookServiceImpl implements BookService {

    private final DaoFactory daoFactory = DaoFactory.getInstance();
    private final BookDAO bookDao = daoFactory.getBookDAO();

    @Override
    public void addBook(Book book) throws ServiceException {
        if (!BookValidator.validateAuthorName(book.getAuthor().getName())) throw new InvalidAuthorNameException("Author name is incorrect");
        if (!BookValidator.validateBookYear(book.getPublish())) throw new InvalidPublishException("Year of publishing is incorrect");
        if (isBookIdExist(book.getId())) throw new BookIDExistException("Book with " + (book.getId()) + "exist!");
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
            Book book = bookDao.findByName(name);
            if (book == null) throw new BookNotFoundException("Book not found");
            return book;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public boolean isBookIdExist(Integer field) throws ServiceException {

        List<Book> bookList = findAll();

        for (Book item : bookList) {
            if (item.getId() == field) return true;
        }
        return false;
    }

}
