package by.training.finalproject.dal;

public interface TransactionFactory {
    Transaction createTransaction();
    void close() throws DataObjectException;
}
