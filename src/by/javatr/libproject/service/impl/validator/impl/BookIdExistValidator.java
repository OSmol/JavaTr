package by.javatr.libproject.service.impl.validator.impl;

import by.javatr.libproject.dao.exception.DAOException;
import by.javatr.libproject.dao.factory.DaoFactory;
import by.javatr.libproject.dao.impl.BookDaoImpl;
import by.javatr.libproject.entity.Book;
import by.javatr.libproject.service.exception.ServiceException;
import by.javatr.libproject.service.impl.validator.Validator;

import java.util.List;

public class BookIdExistValidator implements Validator<Integer> {

    @Override
    public boolean validate(Integer field) throws ServiceException {
        DaoFactory daoFactory = new DaoFactory();
        BookDaoImpl bookDao = daoFactory.getBookDAO("BookFile.txt");
        List<Book> bookList = null;

        try {
            bookList = bookDao.getAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        for (Book item : bookList) {
            if (item.getId() == field) return true;
        }
        return false;
    }
}
