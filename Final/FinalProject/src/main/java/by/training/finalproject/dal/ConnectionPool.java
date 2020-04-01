package by.training.finalproject.dal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private List<Connection> availableConns = new LinkedList<>();
    private List<Connection> usedConns = new LinkedList<>();
    private String login;
    private String pass;

    private String url;
    private ReentrantLock locker =new ReentrantLock();
    private static ConnectionPool instance = new ConnectionPool();
    public static ConnectionPool getInstance(){
        return instance;
    }
    private ConnectionPool() {
    }

    public void init(String url,String login,String pass, int initConnCnt)throws DataObjectException {
        this.url = url;
        this.login = login;
        this.pass = pass;
        for (int i = 0; i < initConnCnt; i++) {
            availableConns.add(newConnection());
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

    public Connection getConnection() throws DataObjectException {
        locker.lock();
        Connection newConn = null;
        if (!availableConns.isEmpty()) {
            newConn = availableConns.get(0);
            availableConns.remove(0);
        }else {
            throw new DataObjectException("No free connections!");
        }
        usedConns.add(newConn);
        locker.unlock();
        return newConn;
    }

    public void returnConnection(Connection c) throws DataObjectException {
        locker.lock();
        if (c != null) {
            if (usedConns.remove(c)) {
                availableConns.add(c);
            } else {
                throw new DataObjectException("Connection not in the usedConns array");
            }
        }
        locker.unlock();
    }

    public int getAvailableConnsCnt() {
        return availableConns.size();
    }
}
