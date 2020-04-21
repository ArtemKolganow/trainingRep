package by.training.finalproject.dal.impl;

import by.training.finalproject.dal.DataObjectException;
import by.training.finalproject.dal.SaleDAO;
import by.training.finalproject.entity.Sale;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SaleDAOimpl implements SaleDAO {
    private static final Logger logger = LogManager.getLogger(SaleDAOimpl.class);
    private Connection cn;
    private static final String SQL_SELECT_ALL_SALES = "SELECT * FROM workshopdb.sales";
    private static final String SQL_SELECT_SALE_BY_ID = "SELECT * FROM workshopdb.sales WHERE product_id=?";
    private static final String SQL_DELETE_ALL_SALE_BY_ID = "DELETE FROM workshopdb.sales WHERE product_id=?";
    private static final String SQL_INSERT_SALE = "INSERT INTO workshopdb.sales (`product_id`,`sales`) VALUES (?,?)";
    private static final String SQL_UPDATE_SALE = "UPDATE workshopdb.sales SET `sales`=? WHERE `product_id`=?";


    @Override
    public List<Sale> findAll() throws DataObjectException {
        List<Sale> sales = new ArrayList<>();
        try {
            try(Statement st = cn.createStatement()){

                try (ResultSet resultSet = st.executeQuery(SQL_SELECT_ALL_SALES)) {
                    while (resultSet.next()) {
                        Sale sale = new Sale();
                        sale.setSaleValue(resultSet.getDouble("sales"));
                        sale.setId(resultSet.getInt("product_id"));
                        sales.add(sale);
                    }
                }
            }
        } catch (SQLException e) {
            throw new DataObjectException("In select all.",e);
        }
        return sales;
    }

    @Override
    public Sale findEntityById(Integer id) throws DataObjectException {
        Sale sale = new Sale();
        try {
            try(PreparedStatement st = cn.prepareStatement(SQL_SELECT_SALE_BY_ID)){
                st.setString(1, id.toString());
                try (ResultSet resultSet = st.executeQuery()) {
                    while (resultSet.next()) {
                        sale.setSaleValue(resultSet.getDouble("sales"));
                        sale.setId(resultSet.getInt("product_id"));
                    }
                }
            }
        } catch (SQLException e) {
            throw new DataObjectException("In select by id.",e);
        }
        return sale;
    }

    @Override
    public boolean delete(Sale entity) throws DataObjectException {
        boolean result;
        try{
            try(PreparedStatement pr = cn.prepareStatement(SQL_DELETE_ALL_SALE_BY_ID)){
                pr.setString(1,String.valueOf(entity.getId()));
                result = pr.execute();
            }
        } catch (SQLException e) {
            throw new DataObjectException("In delete.", e);
        }
        return result;
    }

    @Override
    public boolean create(Sale entity) throws DataObjectException {
        boolean result;
        try{
            try(PreparedStatement pr = cn.prepareStatement(SQL_INSERT_SALE)){
                pr.setString(1,String.valueOf(entity.getId()));
                pr.setString(2,String.valueOf(entity.getSaleValue()));
                result = pr.execute();
            }
        } catch (SQLException e) {
            throw new DataObjectException("In create.", e);
        }
        return result;
    }

    @Override
    public void update(Sale entity) throws DataObjectException {
        try{
            try(PreparedStatement pr = cn.prepareStatement(SQL_UPDATE_SALE)){
                pr.setString(1,String.valueOf(entity.getSaleValue()));
                pr.setString(2,String.valueOf(entity.getId()));

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
