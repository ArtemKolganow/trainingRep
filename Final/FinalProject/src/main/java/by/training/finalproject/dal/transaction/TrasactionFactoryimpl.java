package by.training.finalproject.dal.transaction;


import by.training.finalproject.dal.pool.ConnectionPool;
import by.training.finalproject.dal.DataObjectException;
import by.training.finalproject.dal.pool.PooledConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class TrasactionFactoryimpl implements TransactionFactory {

    private static final Logger logger = LogManager.getLogger(TrasactionFactoryimpl.class);
    private PooledConnection connection;

    public TrasactionFactoryimpl() throws DataObjectException {

        try {
            connection = ConnectionPool.getInstance().getPooledConnection();
            connection.getConnection().setAutoCommit(false);
        } catch(DataObjectException | SQLException e) {
            logger.error("Fail to turn off autocommit for database connection", e);
            throw new DataObjectException(e);
        }
    }
    @Override
    public Transaction createTransaction() {
        return new Transactionimpl(connection);
    }



    @Override
    public void close() throws DataObjectException {
        try {
            ConnectionPool.getInstance().returnConnection(connection);
        } catch (DataObjectException e) {
            throw new DataObjectException("Error in Trasaction Close", e);
        }
    }
}
