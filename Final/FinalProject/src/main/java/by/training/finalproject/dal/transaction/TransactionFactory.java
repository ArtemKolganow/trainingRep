package by.training.finalproject.dal.transaction;

import by.training.finalproject.dal.DataObjectException;

public interface TransactionFactory {
    Transaction createTransaction();
    void close() throws DataObjectException;
}
