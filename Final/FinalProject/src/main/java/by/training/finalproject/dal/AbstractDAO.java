package by.training.finalproject.dal;

import by.training.finalproject.entity.Entity;

import java.sql.Connection;
import java.util.List;

public interface AbstractDAO <K, T extends Entity>  {
    List<T> findAll() throws DataObjectException;
    boolean delete(T entity) throws DataObjectException;
    boolean create(T entity) throws DataObjectException;
    void update(T entity) throws DataObjectException;
    Connection getCn();
    void setCn(Connection cn);
}