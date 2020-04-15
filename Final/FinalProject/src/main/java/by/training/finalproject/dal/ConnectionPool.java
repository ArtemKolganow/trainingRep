package by.training.finalproject.dal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private List<PooledConnection> availableConns = new LinkedList<>();
    private String login;
    private String pass;
    private int maxConns;
    private int connectionCounter;
    private String url;
    private ReentrantLock locker =new ReentrantLock();
    private static ConnectionPool instance = new ConnectionPool();
    public static ConnectionPool getInstance(){
        return instance;
    }
    private ConnectionPool() {
    }

    public void init(String url,String login,String pass, int initConnCnt, int maxConns)throws DataObjectException {
        this.url = url;
        this.login = login;
        this.pass = pass;
        this.maxConns = maxConns;
        for (int i = 0; i < initConnCnt; i++) {
            availableConns.add(new PooledConnection(newConnection(),false));
        }
    }

    private Connection newConnection() throws DataObjectException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,login,pass);
        } catch (Exception e) {
            throw new DataObjectException(e);
        }
        return conn;
    }

    PooledConnection getPooledConnection() throws DataObjectException {
        locker.lock();
        PooledConnection newConn = null;
        if (!availableConns.isEmpty()) {
            newConn = availableConns.get(0);
            availableConns.remove(0);
            connectionCounter++;
        }else {
            if(connectionCounter<=maxConns){
                newConn = new PooledConnection(newConnection(),true);
                connectionCounter++;
            }
        }
        locker.unlock();
        return newConn;
    }

    void returnConnection(PooledConnection c) throws DataObjectException {
        locker.lock();
        if (c != null) {
            if (c.isTemp()) {
                try {
                    c.getConnection().close();
                } catch (SQLException e) {
                    throw new DataObjectException(e);
                }
            } else {
                availableConns.add(c);
            }
        }
        locker.unlock();
    }

}
