package by.training.finalproject.dal;

import java.util.List;

public abstract class AbstractDAO <K, T>  {
    public abstract List<T> findAll() throws DataObjectException;
    public abstract T findEntityById(K id) throws DataObjectException;
    public abstract boolean delete(K id) throws DataObjectException;
    public abstract boolean create(T entity) throws DataObjectException;
    public abstract T update(T entity);
}