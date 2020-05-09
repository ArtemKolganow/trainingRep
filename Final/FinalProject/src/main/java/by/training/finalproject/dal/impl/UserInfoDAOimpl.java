package by.training.finalproject.dal.impl;

import by.training.finalproject.dal.DataObjectException;
import by.training.finalproject.dal.UserInfoDAO;
import by.training.finalproject.entity.UserInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserInfoDAOimpl implements UserInfoDAO {
    private static final Logger logger = LogManager.getLogger(UserInfoDAOimpl.class);
    private Connection cn;
    private static final String SQL_SELECT_ALL_USERINFO = "SELECT * FROM workshopdb.userinfo";
    private static final String SQL_SELECT_USERINFO_BY_ID = "SELECT * FROM workshopdb.userinfo WHERE id=?";
    private static final String SQL_DELETE_USERINFO_BY_ID = "DELETE FROM workshopdb.userinfo WHERE id=?";
    private static final String SQL_INSERT_USERINFO = "INSERT INTO workshopdb.userinfo (`id`,`name`,`surname`,`phoneNumber`) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE_USERINFO = "UPDATE workshopdb.userinfo SET `name`=?,`surname`=?,`phoneNumber`=? WHERE `id`=?";

    @Override
    public List<UserInfo> findAll() throws DataObjectException {
        List<UserInfo> users = new ArrayList<>();
        try {
            try(Statement st = cn.createStatement()){

                try (ResultSet resultSet = st.executeQuery(SQL_SELECT_ALL_USERINFO)) {
                    while (resultSet.next()) {
                        UserInfo user = new UserInfo();
                        user.setId(resultSet.getInt("id"));
                        user.setName(resultSet.getString("name"));
                        user.setSurname(resultSet.getString("surname"));
                        user.setPhoneNumber(resultSet.getString("phoneNumber"));
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
    public boolean delete(UserInfo entity) throws DataObjectException {
        boolean result;
        try{
            try(PreparedStatement pr = cn.prepareStatement(SQL_DELETE_USERINFO_BY_ID)){
                pr.setString(1,String.valueOf(entity.getId()));
                result = pr.execute();
            }
        } catch (SQLException e) {
            throw new DataObjectException(e);
        }
        return result;
    }

    @Override
    public boolean create(UserInfo entity) throws DataObjectException {
        boolean result;
        try{
            try(PreparedStatement pr = cn.prepareStatement(SQL_INSERT_USERINFO)){
                pr.setString(1,String.valueOf(entity.getId()));
                pr.setString(2,entity.getName());
                pr.setString(3,entity.getSurname());
                pr.setString(4,entity.getPhoneNumber());
                result = pr.execute();
            }
        } catch (SQLException e) {
            throw new DataObjectException(e);
        }
        return result;
    }

    @Override
    public void update(UserInfo entity) throws DataObjectException {
        try{
            try(PreparedStatement pr = cn.prepareStatement(SQL_UPDATE_USERINFO)){
                pr.setString(1,entity.getName());
                pr.setString(2,entity.getSurname());
                pr.setString(3,entity.getPhoneNumber());
                pr.setString(5,String.valueOf(entity.getId()));
                pr.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DataObjectException(e);
        }
    }

    @Override
    public Connection getCn() {
        return cn;
    }

    @Override
    public void setCn(Connection cn) {
        this.cn = cn;
    }

    @Override
    public UserInfo findEntityById(Integer id) throws DataObjectException {
        UserInfo user = new UserInfo();
        try {
            try(PreparedStatement st = cn.prepareStatement(SQL_SELECT_USERINFO_BY_ID)){
                st.setString(1, id.toString());
                try (ResultSet resultSet = st.executeQuery()) {
                    while (resultSet.next()) {
                        user.setId(resultSet.getInt("id"));
                        user.setName(resultSet.getString("name"));
                        user.setSurname(resultSet.getString("surname"));
                        user.setPhoneNumber(resultSet.getString("phoneNumber"));
                    }
                }
            }
        } catch (SQLException e) {
            throw new DataObjectException(e);
        }
        return user;
    }
}
