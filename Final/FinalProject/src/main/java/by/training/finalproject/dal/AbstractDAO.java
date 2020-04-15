package by.training.finalproject.dal;

import by.training.finalproject.entity.Entity;

import java.sql.Connection;
import java.util.List;

interface AbstractDAO <K, T extends Entity>  {
    List<T> findAll() throws DataObjectException;
    T findEntityById(K id) throws DataObjectException;
    boolean delete(K id) throws DataObjectException;
    boolean create(T entity) throws DataObjectException;
    void update(T entity) throws DataObjectException;
    Connection getCn();
    void setCn(Connection cn);
}