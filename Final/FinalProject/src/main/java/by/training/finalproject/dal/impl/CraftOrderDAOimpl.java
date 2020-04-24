package by.training.finalproject.dal.impl;

import by.training.finalproject.dal.CraftOrderDAO;
import by.training.finalproject.dal.DataObjectException;
import by.training.finalproject.entity.CraftOrder;
import by.training.finalproject.entity.State;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CraftOrderDAOimpl implements CraftOrderDAO {
    private static final Logger logger = LogManager.getLogger(CraftOrderDAOimpl.class);
    private Connection cn;
    private static final String SQL_SELECT_ALL_CRAFTORDERS = "SELECT * FROM workshopdb.craftorder";
    private static final String SQL_SELECT_CRAFTORDER_BY_ID = "SELECT * FROM workshopdb.craftorder WHERE id=?";
    private static final String SQL_DELETE_CRAFTORDER_BY_ID = "DELETE FROM workshopdb.craftorder WHERE id=?";
    private static final String SQL_INSERT_CRAFTORDER = "INSERT INTO workshopdb.craftorder (id, user_id, title, orderDescription, date, state, price) VALUES (?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE_CRAFTORDER = "UPDATE workshopdb.craftorder SET user_id=?, title=?, orderDescription=?, date=?, state=?, price=? WHERE `id`=?";

    @Override
    public List<CraftOrder> findAll() throws DataObjectException {
        List<CraftOrder> craftOrders = new ArrayList<>();
        try {
            try(Statement st = cn.createStatement()){

                try (ResultSet resultSet = st.executeQuery(SQL_SELECT_ALL_CRAFTORDERS)) {
                    while (resultSet.next()) {
                        CraftOrder craftOrder = new CraftOrder();
                        craftOrder.setId(resultSet.getInt("id"));
                        craftOrder.setUserId(resultSet.getInt("user_id"));
                        craftOrder.setTitle(resultSet.getString("title"));
                        craftOrder.setOrderDescription(resultSet.getString("orderDescription"));
                        craftOrder.setDate(LocalDate.parse(resultSet.getString("date")));
                        craftOrder.setState(State.valueOf(resultSet.getString("state")));
                        craftOrder.setPrice(resultSet.getDouble("price"));
                        craftOrders.add(craftOrder);
                    }
                }
            }
        } catch (SQLException e) {
            throw new DataObjectException("In select all.",e);
        }
        return craftOrders;
    }

    @Override
    public boolean delete(CraftOrder entity) throws DataObjectException {
        boolean result;
        try{
            try(PreparedStatement pr = cn.prepareStatement(SQL_DELETE_CRAFTORDER_BY_ID)){
                pr.setString(1,String.valueOf(entity.getId()));
                result = pr.execute();
            }
        } catch (SQLException e) {
            throw new DataObjectException("In delete.", e);
        }
        return result;
    }

    @Override
    public boolean create(CraftOrder entity) throws DataObjectException {
        boolean result;
        try{
            try(PreparedStatement pr = cn.prepareStatement(SQL_INSERT_CRAFTORDER)){
                pr.setString(1,String.valueOf(entity.getId()));
                pr.setString(2,String.valueOf(entity.getUserId()));
                pr.setString(3,entity.getTitle());
                pr.setString(4,entity.getOrderDescription());
                pr.setString(5,entity.getDate().toString());
                pr.setString(6,entity.getState().getValue());
                pr.setString(7,String.valueOf(entity.getPrice()));
                result = pr.execute();
            }
        } catch (SQLException e) {
            throw new DataObjectException("In create.", e);
        }
        return result;
    }

    @Override
    public void update(CraftOrder entity) throws DataObjectException {
        try{
            try(PreparedStatement pr = cn.prepareStatement(SQL_UPDATE_CRAFTORDER)){
                pr.setString(7,String.valueOf(entity.getId()));
                pr.setString(1,String.valueOf(entity.getUserId()));
                pr.setString(2,entity.getTitle());
                pr.setString(3,entity.getOrderDescription());
                pr.setString(4,entity.getDate().toString());
                pr.setString(5,entity.getState().getValue());
                pr.setString(6,String.valueOf(entity.getPrice()));
                pr.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DataObjectException("In update.", e);
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
    public CraftOrder findEntityById(Integer id) throws DataObjectException {
        CraftOrder craftOrder = new CraftOrder();
        try {
            try(PreparedStatement st = cn.prepareStatement(SQL_SELECT_CRAFTORDER_BY_ID)) {
                st.setString(1, id.toString());
                try (ResultSet resultSet = st.executeQuery()) {
                    while (resultSet.next()) {
                        craftOrder.setId(resultSet.getInt("id"));
                        craftOrder.setUserId(resultSet.getInt("user_id"));
                        craftOrder.setTitle(resultSet.getString("title"));
                        craftOrder.setOrderDescription(resultSet.getString("orderDescription"));
                        craftOrder.setDate(LocalDate.parse(resultSet.getString("date")));
                        craftOrder.setState(State.valueOf(resultSet.getString("state")));
                        craftOrder.setPrice(resultSet.getDouble("price"));
                    }
                }
            }
        } catch (SQLException e) {
            throw new DataObjectException("In select by id.",e);
        }
        return craftOrder;
    }
}
