package by.training.finalproject.dal.impl;

import by.training.finalproject.dal.DataObjectException;
import by.training.finalproject.dal.ProductDAO;
import by.training.finalproject.dal.SaleDAO;
import by.training.finalproject.dal.pool.ConnectionPool;
import by.training.finalproject.entity.Product;
import by.training.finalproject.entity.Sale;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOimpl implements ProductDAO {
    private static final Logger logger = LogManager.getLogger(ProductDAOimpl.class);
    private Connection cn;

    private static final String SQL_SELECT_ALL_PRODUCTS = "SELECT product.id, type.type, product.name, product.price, product.weight, product.img" +
            " FROM workshopdb.product INNER JOIN workshopdb.type ON product.type_id = type.id";
    private static final String SQL_SELECT_PRODUCT_BY_ID = "SELECT product.id, type.type, product.name, product.price, product.weight, product.img" +
            " FROM (workshopdb.product INNER JOIN workshopdb.type ON product.type_id = type.id) WHERE product.id=?";
    private static final String SQL_DELETE_PRODUCT_BY_ID = "DELETE FROM workshopdb.product WHERE id=?";
    private static final String SQL_INSERT_PRODUCT = "INSERT INTO workshopdb.product(id, type_id, name, price, weight, img) VALUES (?,?,?,?,?,?)";
    private static final String SQL_UPDATE_PRODUCT = "UPDATE workshopdb.product SET `type_id`=?,`name`=?,`price`=?,`weight`=?,`img`=? WHERE `id`=?";
    private static final String SQL_SELECT_TYPE_TO_ID = "SELECT id FROM workshopdb.type WHERE type=?";
    private static final String SQL_SELECT_ID_TO_TYPE = "SELECT type FROM workshopdb.type WHERE id=?";
    private static final String SQL_SELECT_MATERIAL_TO_ID = "SELECT id FROM workshopdb.material WHERE material.name=?";
    private static final String SQL_SELECT_ID_TO_MATERIAL = "SELECT name FROM workshopdb.material WHERE material.id=?";
    private static final String SQL_SELECT_MATERIALLIST = "SELECT * FROM workshopdb.materiallist WHERE product_id=?";

    @Override
    public List<Product> findAll() throws DataObjectException {
        List<Product> products = new ArrayList<>();
        try {
            try(Statement st = cn.createStatement()){
                try (ResultSet resultSet = st.executeQuery(SQL_SELECT_ALL_PRODUCTS)) {
                    while (resultSet.next()) {
                        Product product = new Product();
                        productFromResultSet(product, resultSet);
                        products.add(product);
                    }
                }
            }
        } catch (SQLException e) {
            throw new DataObjectException("In select all.",e);
        }
        return products;
    }

    @Override
    public Product findEntityById(Integer id) throws DataObjectException {
        Product product = new Product();
        try {
            try(PreparedStatement st = cn.prepareStatement(SQL_SELECT_PRODUCT_BY_ID)){
                st.setString(1, id.toString());
                try (ResultSet resultSet = st.executeQuery()) {
                    while (resultSet.next()) {
                        productFromResultSet(product, resultSet);
                    }
                }
            }
        } catch (SQLException e) {
            throw new DataObjectException("In select by id.",e);
        }
        return product;
    }

    private void productFromResultSet(Product product, ResultSet resultSet) throws SQLException, DataObjectException {
        product.setId(resultSet.getInt("id"));
        product.setType(getTypeById(Integer.parseInt(resultSet.getString("type"))));
        product.setName(resultSet.getString("name"));
        product.setPrice(resultSet.getDouble("price"));
        product.setWeight(resultSet.getDouble("weight"));
        product.setImage(resultSet.getString("img"));
        product.setMaterials(readMaterialList(resultSet.getInt("id")));
    }

    @Override
    public boolean delete(Product entity) throws DataObjectException {
        boolean result;
        try{
            try(PreparedStatement pr = cn.prepareStatement(SQL_DELETE_PRODUCT_BY_ID)){
                pr.setString(1,String.valueOf(entity.getId()));
                result = pr.execute();
            }
        } catch (SQLException e) {
            throw new DataObjectException("In delete.", e);
        }
        return result;
    }

    @Override
    public boolean create(Product entity) throws DataObjectException {
        boolean result = false;

        try{
            try(PreparedStatement pr = cn.prepareStatement(SQL_INSERT_PRODUCT)){
                pr.setString(1,String.valueOf(entity.getId()));
                pr.setString(2,String.valueOf(getTypeId(entity.getType())));
                pr.setString(3,entity.getName());
                pr.setString(4,String.valueOf(entity.getPrice()));
                pr.setString(5,String.valueOf(entity.getWeight()));
                pr.setString(6,entity.getImage());
                result = pr.execute();
            }
            for(int i = 0; i<entity.getMaterials().size();i++){
                try(PreparedStatement pr = cn.prepareStatement("INSERT INTO workshopdb.materiallist (material_id, product_id) VALUES (?,?)")){
                    pr.setString(1,String.valueOf(getMaterialId(entity.getMaterials().get(i))));
                    pr.setString(2,String.valueOf(entity.getId()));
                }
            }
            if(!entity.getSale().getSaleValue().equals(1.0)) {
                SaleDAO saleDAO = new SaleDAOimpl();
                saleDAO.setCn(cn);
                saleDAO.create(entity.getSale());
            }
        } catch (SQLException e) {
            throw new DataObjectException("In create.", e);
        }
        return result;
    }

    @Override
    public void update(Product entity) throws DataObjectException {
        try{
            try(PreparedStatement pr = cn.prepareStatement(SQL_UPDATE_PRODUCT)){
                pr.setString(1,String.valueOf(getTypeId(entity.getType())));
                pr.setString(2,entity.getName());
                pr.setString(3,String.valueOf(entity.getPrice()));
                pr.setString(4,String.valueOf(entity.getWeight()));
                pr.setString(5,entity.getImage());
                pr.setString(6,String.valueOf(entity.getId()));
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

    private int getTypeId(String type) throws DataObjectException {
        try {
            try(PreparedStatement st = cn.prepareStatement(SQL_SELECT_TYPE_TO_ID)){
                st.setString(1, type);
                try (ResultSet resultSet = st.executeQuery()) {
                    resultSet.next();
                    return resultSet.getInt("id");
                }
            }
        } catch (SQLException e) {
            throw new DataObjectException("In select type.",e);
        }
    }

    private String getTypeById(Integer id) throws DataObjectException {
        try {
            try(PreparedStatement st = cn.prepareStatement(SQL_SELECT_ID_TO_TYPE)){
                st.setString(1, id.toString());
                try (ResultSet resultSet = st.executeQuery()) {
                    resultSet.next();
                    return resultSet.getString("type");
                }
            }
        } catch (SQLException e) {
            throw new DataObjectException("In select type.",e);
        }
    }

    private int getMaterialId(String material) throws DataObjectException {
        try {
            try(PreparedStatement st = cn.prepareStatement(SQL_SELECT_MATERIAL_TO_ID)){
                st.setString(1, material);
                try (ResultSet resultSet = st.executeQuery()) {
                    resultSet.next();
                    return resultSet.getInt("id");
                }
            }
        } catch (SQLException e) {
            throw new DataObjectException("In select type.",e);
        }
    }

    private String getMaterialById(Integer id) throws DataObjectException {
        try {
            try(PreparedStatement st = cn.prepareStatement(SQL_SELECT_ID_TO_MATERIAL)){
                st.setString(1, id.toString());
                try (ResultSet resultSet = st.executeQuery()) {
                    resultSet.next();
                    return resultSet.getString("name");
                }
            }
        } catch (SQLException e) {
            throw new DataObjectException("In select type.",e);
        }
    }

    private List<String> readMaterialList(Integer id) throws DataObjectException {
        List<String> materials = new ArrayList<>();
        try {
            try(PreparedStatement st = cn.prepareStatement(SQL_SELECT_MATERIALLIST)){
                st.setString(1, id.toString());
                try (ResultSet resultSet = st.executeQuery()) {
                    while (resultSet.next()) {
                        materials.add(getMaterialById(resultSet.getInt("material_id")));
                    }
                }
            }
        } catch (SQLException e) {
            throw new DataObjectException("In select materials by id.",e);
        }
        return materials;
    }
}
