package dao;

import dao.exception.DAOException;


import java.util.List;


public interface EntityDAO<T>{
    List<T> getAll() throws DAOException;

    void insert(final T emp) throws DAOException;

    void update(final T emp) throws DAOException;

    void delete(final T emp) throws DAOException;

    T get(final int id) throws DAOException;

    boolean isName(String name) throws DAOException;
}
