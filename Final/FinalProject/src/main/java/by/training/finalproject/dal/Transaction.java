package by.training.finalproject.dal;

public interface Transaction {
    AbstractDAO createDao(String className);
    void commit() throws DataObjectException;
    void rollback() throws DataObjectException;
}
