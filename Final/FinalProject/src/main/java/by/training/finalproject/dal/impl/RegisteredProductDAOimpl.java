package by.training.finalproject.dal.impl;

import by.training.finalproject.dal.CraftOrderDAO;
import by.training.finalproject.dal.DataObjectException;
import by.training.finalproject.dal.ProductDAO;
import by.training.finalproject.dal.RegisteredProductDAO;
import by.training.finalproject.entity.RegisteredProduct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegisteredProductDAOimpl implements RegisteredProductDAO {
    private static final Logger logger = LogManager.getLogger(RegisteredProductDAOimpl.class);
    private Connection cn;
    private static final String SQL_SELECT_ALL_REGISTERED_PRODUCTS = "SELECT * FROM workshopdb.productlist";
    private static final String SQL_SELECT_REGISTERED_PRODUCT_BY_ID = "SELECT * FROM workshopdb.productlist WHERE order_id=?";
    private static final String SQL_DELETE_REGISTERED_PRODUCT_BY_IDS = "DELETE FROM workshopdb.productlist WHERE order_id=? AND product_id=?";
    private static final String SQL_DELETE_REGISTERED_PRODUCT_BY_ORDER_ID = "DELETE FROM workshopdb.productlist WHERE order_id=?";
    private static final String SQL_INSERT_REGISTERED_PRODUCT = "INSERT INTO workshopdb.productlist (order_id, product_id, quantity) VALUES (?,?,?)";
    private static final String SQL_UPDATE_REGISTERED_PRODUCT = "UPDATE workshopdb.productlist SET quantity=? WHERE order_id=? AND product_id=?";

    @Override
    public List<RegisteredProduct> findEntityById(Integer id) throws DataObjectException {
        List<RegisteredProduct> registeredProducts = new ArrayList<>();

        try {
            try(PreparedStatement st = cn.prepareStatement(SQL_SELECT_REGISTERED_PRODUCT_BY_ID)){
                st.setString(1, id.toString());
                try (ResultSet resultSet = st.executeQuery()) {
                    while (resultSet.next()) {
                        RegisteredProduct registeredProduct = new RegisteredProduct();
                        registeredProduct.setOrderId(id);
                        registeredProduct.setQuantity(resultSet.getInt("quantity"));
                        int productId = resultSet.getInt("product_id");
                        readProduct(registeredProduct, productId);
                        registeredProducts.add(registeredProduct);
                    }
                }
            }
        } catch (SQLException e) {
            throw new DataObjectException(e);
        }
        return registeredProducts;
    }

    @Override
    public boolean deleteByOrderId(int id) throws DataObjectException {
        boolean result;
        try{
            try(PreparedStatement pr = cn.prepareStatement(SQL_DELETE_REGISTERED_PRODUCT_BY_ORDER_ID)){
                pr.setString(1,String.valueOf(id));
                result = pr.execute();
            }
        } catch (SQLException e) {
            throw new DataObjectException( e);
        }
        return result;
    }

    @Override
    public List<RegisteredProduct> findAll() throws DataObjectException {
        List<RegisteredProduct> registeredProducts = new ArrayList<>();
        try {
            try(Statement st = cn.createStatement()){

                try (ResultSet resultSet = st.executeQuery(SQL_SELECT_ALL_REGISTERED_PRODUCTS)) {
                    while (resultSet.next()) {
                        RegisteredProduct registeredProduct = new RegisteredProduct();
                        registeredProduct.setOrderId(resultSet.getInt("order_id"));
                        registeredProduct.setQuantity(resultSet.getInt("quantity"));
                        int productId = resultSet.getInt("product_id");
                        readProduct(registeredProduct, productId);
                        registeredProducts.add(registeredProduct);
                    }
                }
            }
        } catch (SQLException e) {
            throw new DataObjectException(e);
        }
        return registeredProducts;
    }

    private void readProduct(RegisteredProduct registeredProduct, int productId) throws DataObjectException {
            ProductDAO productDAO = new ProductDAOimpl();
            productDAO.setCn(cn);
            registeredProduct.setProduct(productDAO.findEntityById(productId));
    }

    @Override
    public boolean delete(RegisteredProduct entity) throws DataObjectException {
        boolean result;
        try{
            try(PreparedStatement pr = cn.prepareStatement(SQL_DELETE_REGISTERED_PRODUCT_BY_IDS)){
                pr.setString(1,String.valueOf(entity.getOrderId()));
                pr.setString(2,String.valueOf(entity.getProduct().getId()));
                result = pr.execute();
            }
        } catch (SQLException e) {
            throw new DataObjectException( e);
        }
        return result;
    }

    @Override
    public boolean create(RegisteredProduct entity) throws DataObjectException {
        boolean result;
        try{
            try(PreparedStatement pr = cn.prepareStatement(SQL_INSERT_REGISTERED_PRODUCT)){
                pr.setString(1,String.valueOf(entity.getOrderId()));
                pr.setString(2,String.valueOf(entity.getProduct().getId()));
                pr.setString(3,String.valueOf(entity.getQuantity()));
                result = pr.execute();
            }
        } catch (SQLException e) {
            throw new DataObjectException(e);
        }
        return result;
    }

    @Override
    public void update(RegisteredProduct entity) throws DataObjectException {
        try{
            try(PreparedStatement pr = cn.prepareStatement(SQL_UPDATE_REGISTERED_PRODUCT)){
                pr.setString(2,String.valueOf(entity.getOrderId()));
                pr.setString(3,String.valueOf(entity.getProduct().getId()));
                pr.setString(1,String.valueOf(entity.getQuantity()));

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
}
