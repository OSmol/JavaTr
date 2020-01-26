package by.javatr.libproject.dao;

import by.javatr.libproject.dao.exception.DAOException;

import java.util.List;

public interface LibraryDAO <E,K> {
    void add(E entity) throws DAOException;
    void delete(K index) throws DAOException;
    void update(K index, E newEntity) throws DAOException;
    List<E> getAll() throws DAOException;
}
