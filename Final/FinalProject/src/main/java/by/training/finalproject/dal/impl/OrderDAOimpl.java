package by.training.finalproject.dal.impl;

import by.training.finalproject.dal.DataObjectException;
import by.training.finalproject.dal.OrderDAO;
import by.training.finalproject.dal.RegisteredProductDAO;
import by.training.finalproject.entity.Order;
import by.training.finalproject.entity.RegisteredProduct;
import by.training.finalproject.entity.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOimpl implements OrderDAO {
    private static final Logger logger = LogManager.getLogger(CraftOrderDAOimpl.class);
    private Connection cn;
    private static final String SQL_SELECT_ALL_ORDERS = "SELECT * FROM workshopdb.order";
    private static final String SQL_SELECT_ORDER_BY_ID = "SELECT * FROM workshopdb.order WHERE id=?";
    private static final String SQL_SELECT_ORDER_BY_USER_ID = "SELECT * FROM workshopdb.order WHERE id=?";
    private static final String SQL_DELETE_ORDER_BY_ID = "DELETE FROM workshopdb.order WHERE id=?";
    private static final String SQL_INSERT_ORDER = "INSERT INTO workshopdb.order (id, user_id, status, date, deliverydate, price) VALUES (?,?,?,?,?,?)";
    private static final String SQL_UPDATE_ORDER = "UPDATE workshopdb.order SET  status=?, date=?, deliverydate=?, price=? WHERE `id`=?";


    @Override
    public List<Order> findAll() throws DataObjectException {
        List<Order> orders = new ArrayList<>();
        try {
            RegisteredProductDAO registeredProductDAO = new RegisteredProductDAOimpl();
            registeredProductDAO.setCn(cn);
            try(Statement st = cn.createStatement()){
                try (ResultSet resultSet = st.executeQuery(SQL_SELECT_ALL_ORDERS)) {
                    while (resultSet.next()) {
                        Order order = new Order();
                        orderFromResultSet(order, resultSet);
                        order.setProductList(registeredProductDAO.findEntityById(resultSet.getInt("id")));
                       orders.add(order);
                    }
                }
            }
        } catch (SQLException e) {
            throw new DataObjectException("In select all.",e);
        }
        return orders;
    }

    @Override
    public Order findEntityById(Integer id) throws DataObjectException {
        Order order = new Order();
        try {
            RegisteredProductDAO registeredProductDAO = new RegisteredProductDAOimpl();
            registeredProductDAO.setCn(cn);
            try(PreparedStatement st = cn.prepareStatement(SQL_SELECT_ORDER_BY_ID)){
                st.setString(1, id.toString());
                try (ResultSet resultSet = st.executeQuery()) {
                    while (resultSet.next()) {
                        orderFromResultSet(order, resultSet);
                        order.setProductList(registeredProductDAO.findEntityById(resultSet.getInt("id")));
                    }
                }
            }
        } catch (SQLException e) {
            throw new DataObjectException("In select by id.",e);
        }
        return order;
    }

    private void orderFromResultSet(Order order, ResultSet resultSet) throws SQLException {
        order.setId(resultSet.getInt("id"));
        order.setUserId(resultSet.getInt("user_id"));
        order.setStatus(Status.valueOf(resultSet.getString("status")));
        order.setDate(LocalDate.parse(resultSet.getString("date")));
        order.setDeliveryDate(LocalDate.parse(resultSet.getString("deliverydate")));
        order.setPrice(resultSet.getDouble("price"));
    }

    @Override
    public List<Order> findEntityByUserId(Integer id) throws DataObjectException {
        List<Order> orders = new ArrayList<>();

        try {
            RegisteredProductDAO registeredProductDAO = new RegisteredProductDAOimpl();
            registeredProductDAO.setCn(cn);
            try(PreparedStatement st = cn.prepareStatement(SQL_SELECT_ORDER_BY_USER_ID)){
                st.setString(1, id.toString());
                try (ResultSet resultSet = st.executeQuery()) {
                    while (resultSet.next()) {
                        Order order = new Order();
                        orderFromResultSet(order, resultSet);
                        order.setProductList(registeredProductDAO.findEntityById(resultSet.getInt("id")));
                        orders.add(order);
                    }
                }
            }
        } catch (SQLException e) {
            throw new DataObjectException("In select by id.",e);
        }
        return orders;
    }

    @Override
    public boolean delete(Order entity) throws DataObjectException {
        boolean result;
        try{
            try(PreparedStatement pr = cn.prepareStatement(SQL_DELETE_ORDER_BY_ID)){
                pr.setString(1,String.valueOf(entity.getId()));
                result = pr.execute();
            }
        } catch (SQLException e) {
            throw new DataObjectException("In delete.", e);
        }
        return result;
    }

    @Override
    public boolean create(Order entity) throws DataObjectException {
        boolean result;
        try{
            try(PreparedStatement pr = cn.prepareStatement(SQL_INSERT_ORDER)){
                pr.setString(1,String.valueOf(entity.getId()));
                pr.setString(2,String.valueOf(entity.getUserId()));
                pr.setString(3,entity.getStatus().getValue());
                pr.setString(4,entity.getDate().toString());
                pr.setString(5,entity.getDeliveryDate().toString());
                pr.setString(6,String.valueOf(entity.getPrice()));
                result = pr.execute();
            }
            RegisteredProductDAO registeredProductDAO = new RegisteredProductDAOimpl();
            registeredProductDAO.setCn(cn);
            for (RegisteredProduct registeredProduct : entity.getProductList()){
                registeredProductDAO.create(registeredProduct);
            }
        } catch (SQLException e) {
            throw new DataObjectException("In create.", e);
        }
        return result;
    }

    @Override
    public void update(Order entity) throws DataObjectException {
        try{
            try(PreparedStatement pr = cn.prepareStatement(SQL_UPDATE_ORDER)){
                pr.setString(5,String.valueOf(entity.getId()));
                pr.setString(1,entity.getStatus().getValue());
                pr.setString(2,entity.getDate().toString());
                pr.setString(3,entity.getDeliveryDate().toString());
                pr.setString(4,String.valueOf(entity.getPrice()));

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


}
