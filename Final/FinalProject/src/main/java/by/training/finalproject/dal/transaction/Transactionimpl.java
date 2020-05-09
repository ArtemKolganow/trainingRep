package by.training.finalproject.dal.transaction;

import by.training.finalproject.dal.AbstractDAO;
import by.training.finalproject.dal.DataObjectException;
import by.training.finalproject.dal.impl.*;
import by.training.finalproject.dal.pool.PooledConnection;

import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Transactionimpl implements Transaction {
    private static Map<String, AbstractDAO> classes = new ConcurrentHashMap<>();
    private PooledConnection connection;

    static {
        classes.put("UserDAO", new UserDAOimpl());
        classes.put("ProductDAO", new ProductDAOimpl());
        classes.put("OrderDAO", new OrderDAOimpl());
        classes.put("UserInfoDAO", new UserInfoDAOimpl());
        classes.put("RegisteredProductDAO", new RegisteredProductDAOimpl());
        classes.put("CraftOrderDAO", new CraftOrderDAOimpl());
    }

    Transactionimpl(PooledConnection connection){
        this.connection=connection;
    }

    @Override
    public AbstractDAO createDao(String className) {
        AbstractDAO dao = classes.get(className);
        if(dao != null) {
            dao.setCn(connection.getConnection());
            return dao;
        }
        return null;
    }

    @Override
    public void commit() throws DataObjectException {
        try {
            connection.getConnection().commit();
        } catch( SQLException e) {
            throw new DataObjectException(e);
        }
    }

    @Override
    public void rollback() throws DataObjectException {
        try {
            connection.getConnection().rollback();
        } catch(SQLException e) {
            throw new DataObjectException(e);
        }
    }
}
