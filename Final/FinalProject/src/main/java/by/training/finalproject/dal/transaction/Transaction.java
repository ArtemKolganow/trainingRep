package by.training.finalproject.dal.transaction;

import by.training.finalproject.dal.AbstractDAO;
import by.training.finalproject.dal.DataObjectException;

public interface Transaction {
    AbstractDAO createDao(String className);
    void commit() throws DataObjectException;
    void rollback() throws DataObjectException;
}
