package by.training.finalproject.dal.pool;

import java.sql.Connection;
import java.util.Objects;

public class PooledConnection {
    private Connection connection;
    private boolean isTemp;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean isTemp() {
        return isTemp;
    }

    public void setTemp(boolean isTemp) {
        this.isTemp = isTemp;
    }

    public PooledConnection(Connection connection, boolean isTemp) {
        this.connection = connection;
        this.isTemp = isTemp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PooledConnection that = (PooledConnection) o;
        return isTemp == that.isTemp &&
                Objects.equals(connection, that.connection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connection, isTemp);
    }

    @Override
    public String toString() {
        return "PooledConnection{" +
                "connection=" + connection +
                ", isTemp=" + isTemp +
                '}';
    }
}
