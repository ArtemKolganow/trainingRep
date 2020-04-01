package by.training.finalproject.dal;

import by.training.finalproject.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO<Integer, User> {
    private static final String SQL_SELECT_ALL_USERS = "SELECT * FROM user";
    private static final String SQL_SELECT_ALL_USERS_BY_ID = "SELECT * FROM user WHERE id=?";
    private static final String SQL_DELETE_ALL_USERS_BY_ID = "DELETE * FROM user WHERE id=?";
    private static final String SQL_INSERT_USER = "INSERT INTO (`id`,`login`,`pass`,`email`,`role`) VALUES (?,?,?,?,?)";
    private static final String SQL_UPDATE_USER = "UPDATE user SET ";


    @Override
    public List<User> findAll() throws DataObjectException {
        List<User> users = new ArrayList<>();
        Connection cn = null;
        try {
            cn = ConnectionPool.getInstance().getConnection();
            try(Statement st = cn.createStatement()){

                try (ResultSet resultSet = st.executeQuery(SQL_SELECT_ALL_USERS)) {
                    while (resultSet.next()) {
                        User user = new User();
                        user.setId(resultSet.getInt("id"));
                        user.setLogin(resultSet.getString("login"));
                        user.setPass(resultSet.getString("pass"));
                        user.setEmail(resultSet.getString("email"));
                        user.setRole(resultSet.getInt("role"));
                        users.add(user);
                    }
                }
            }
        } catch (SQLException e) {
            throw new DataObjectException(e);
        }
        finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
        return users;
    }

    @Override
    public User findEntityById(Integer id) throws DataObjectException {
       User user = new User();
        Connection cn = null;
        try {
            cn = ConnectionPool.getInstance().getConnection();
            try(PreparedStatement st = cn.prepareStatement(SQL_SELECT_ALL_USERS_BY_ID)){
                st.setString(1, id.toString());
                try (ResultSet resultSet = st.executeQuery()) {
                    while (resultSet.next()) {
                        user.setId(resultSet.getInt("id"));
                        user.setLogin(resultSet.getString("login"));
                        user.setPass(resultSet.getString("pass"));
                        user.setEmail(resultSet.getString("email"));
                        user.setRole(resultSet.getInt("role"));
                    }
                }
            }
        } catch (SQLException e) {
            throw new DataObjectException(e);
        }
        finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
        return user;
    }

    @Override
    public boolean delete(Integer id) throws DataObjectException {
        Connection cn = null;
        boolean result;
        try{
            cn = ConnectionPool.getInstance().getConnection();
            try(PreparedStatement pr = cn.prepareStatement(SQL_DELETE_ALL_USERS_BY_ID)){
                pr.setString(1,id.toString());
                result = pr.execute();
            }
        } catch (DataObjectException | SQLException e) {
            throw new DataObjectException("In delete.", e);
        }finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
        return result;
    }

    @Override
    public boolean create(User entity) throws DataObjectException {
        Connection cn = null;
        boolean result;
        try{
            cn = ConnectionPool.getInstance().getConnection();
            try(PreparedStatement pr = cn.prepareStatement(SQL_INSERT_USER)){
                pr.setString(1,entity.getId().toString());
                pr.setString(2,entity.getLogin());
                pr.setString(3,entity.getPass());
                pr.setString(4,entity.getEmail());
                pr.setString(5,entity.getRole().toString());
                result = pr.execute();
            }
        } catch (DataObjectException | SQLException e) {
            throw new DataObjectException("In delete.", e);
        }finally {
            ConnectionPool.getInstance().returnConnection(cn);
        }
        return result;
    }

    @Override
    public User update(User entity) {
        return null;
    }
}
