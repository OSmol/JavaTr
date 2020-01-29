package by.javatr.libproject.service.impl.validator.impl;

import by.javatr.libproject.entity.Book;
import by.javatr.libproject.service.exception.ServiceException;
import by.javatr.libproject.service.impl.validator.Validator;

public class BookNotFoundValidator implements Validator<Book> {
    @Override
    public boolean validate(Book field) throws ServiceException {
        if (field == null) return true;
        return false;
    }
}
