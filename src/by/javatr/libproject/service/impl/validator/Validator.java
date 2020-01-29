package by.javatr.libproject.service.impl.validator;

import by.javatr.libproject.dao.factory.DaoFactory;
import by.javatr.libproject.dao.exception.DAOException;
import by.javatr.libproject.dao.impl.BookDaoImpl;
import by.javatr.libproject.dao.impl.UserDaoImpl;
import by.javatr.libproject.entity.Book;
import by.javatr.libproject.entity.User;
import by.javatr.libproject.service.exception.ServiceException;

import java.util.List;

public interface Validator <K> {

     boolean validate(K field) throws ServiceException;

}
