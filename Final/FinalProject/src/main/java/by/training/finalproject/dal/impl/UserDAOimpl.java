package by.training.finalproject.dal.impl;

import by.training.finalproject.dal.DataObjectException;
import by.training.finalproject.dal.UserDAO;
import by.training.finalproject.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOimpl implements UserDAO {
    private static final Logger logger = LogManager.getLogger(UserDAOimpl.class);
    private Connection cn;
    private static final String SQL_SELECT_ALL_USERS = "SELECT * FROM workshopdb.user";
    private static final String SQL_SELECT_USER_BY_ID = "SELECT * FROM workshopdb.user WHERE id=?";
    private static final String SQL_SELECT_USER_BY_LOGIN_AND_PASS = "SELECT id, login, pass, email, role FROM workshopdb.user WHERE login=? AND pass=?";
    private static final String SQL_DELETE_ALL_USERS_BY_ID = "DELETE FROM workshopdb.user WHERE id=?";
    private static final String SQL_INSERT_USER = "INSERT INTO workshopdb.user (`login`,`pass`,`email`,`role`) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE_USER = "UPDATE workshopdb.user SET `login`=?,`pass`=?,`email`=?,`role`=? WHERE `id`=?";


    @Override
    public Connection getCn() {
        return cn;
    }

    @Override
    public void setCn(Connection cn) {
        this.cn = cn;
    }

    @Override
    public List<User> findAll() throws DataObjectException {
        List<User> users = new ArrayList<>();
        try {
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
        return users;
    }

    @Override
    public User findEntityById(Integer id) throws DataObjectException {
       User user = new User();
        try {
            logger.info("Come to DAO user id.");
            try(PreparedStatement st = cn.prepareStatement(SQL_SELECT_USER_BY_ID)){
                st.setString(1, id.toString());
                logger.info("Come to DAO user id result set.");
                userFromResultSet(user, st);
            }
        } catch (SQLException e) {
            throw new DataObjectException(e);
        }
        return user;
    }

    @Override
    public boolean delete(User entity) throws DataObjectException {
        boolean result;
        try{
            try(PreparedStatement pr = cn.prepareStatement(SQL_DELETE_ALL_USERS_BY_ID)){
                pr.setString(1,String.valueOf(entity.getId()));
                result = pr.execute();
            }
        } catch (SQLException e) {
            throw new DataObjectException(e);
        }
        return result;
    }

    @Override
    public boolean create(User entity) throws DataObjectException {
        int result;
        try{
            try(PreparedStatement pr = cn.prepareStatement(SQL_INSERT_USER)){
                pr.setString(1,entity.getLogin());
                pr.setString(2,entity.getPass());
                pr.setString(3,entity.getEmail());
                pr.setString(4,entity.getRole().toString());
                result = pr.executeUpdate();
                logger.info(result);
            }
        } catch (SQLException e) {
            throw new DataObjectException(e);
        }
        return result == 1;
    }

    @Override
    public void update(User entity) throws DataObjectException {
        try{
            try(PreparedStatement pr = cn.prepareStatement(SQL_UPDATE_USER)){
                pr.setString(1,entity.getLogin());
                pr.setString(2,entity.getPass());
                pr.setString(3,entity.getEmail());
                pr.setString(4,entity.getRole().toString());
                pr.setString(5,String.valueOf(entity.getId()));
                pr.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DataObjectException(e);
        }
    }

    @Override
    public User findEntityByLoginAndPass(String login, String pass) throws DataObjectException {
        User user = new User();
        try {
            logger.info("Come 1.");
            logger.info(cn.isClosed());
            try(PreparedStatement st = cn.prepareStatement(SQL_SELECT_USER_BY_LOGIN_AND_PASS)){
                logger.info("Come 2.");
                st.setString(1, login);
                st.setString(2, pass);
                logger.info("Come 3.");
                userFromResultSet(user, st);
            }
        } catch (SQLException e) {
            logger.error(e);
            throw new DataObjectException(e);
        }
        return user;
    }

    private void userFromResultSet(User user, PreparedStatement st) throws SQLException {
        try (ResultSet resultSet = st.executeQuery()) {
            logger.info("Come 4.");
            while (resultSet.next()) {
                logger.info("Come resultSet.");
                user.setId(resultSet.getInt(1));
                user.setLogin(resultSet.getString(2));
                user.setPass(resultSet.getString(3));
                user.setEmail(resultSet.getString(4));
                user.setRole(resultSet.getInt(5));
            }
        }
    }
}
