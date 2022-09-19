package shopcoffee.service;

import shopcoffee.model.Customer;
import shopcoffee.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductServiceImpl implements DaoInterface<Product>{

    private static final String INSERT_PRODUCT_SQL = "INSERT INTO Product (nameProduct, price, amount, image) VALUES (?, ?, ?, ?);";
    private static final String SELECT_PRODUCT_BY_ID = "select idProduct, nameProduct, price, amount, image from Product where idProduct = ?";
    private static final String SELECT_ALL_PRODUCT = "select * from Product";
    private static final String DELETE_PRODUCT_SQL = "delete from Product where idProduct = ?;";
    private static final String UPDATE_PRODUCT_SQL = "update Product set nameProduct = ?, price= ?, amount = ?, image = ? where idProduct = ?;";
    private static final String SELECT_PRODUCT_BY_CONDITION = "select idProduct, nameProduct, price, amount, image from Product where nameProduct = ?;";

    @Override
    public int insert(Product product) {
        int result=0;
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL);
            preparedStatement.setString(1, product.getNameProduct());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getAmount());
            preparedStatement.setString(4, product.getImage());
            result = preparedStatement.executeUpdate();
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(Product product) {
        int result = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_SQL);
            preparedStatement.setString(1, product.getNameProduct());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getAmount());
            preparedStatement.setString(4, product.getImage());
            preparedStatement.setInt(5, product.getIdProduct());
            result = preparedStatement.executeUpdate();
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(int id) {
        int result = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_SQL);
            preparedStatement.setInt(1,id);
            result = preparedStatement.executeUpdate();
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Product> selectAll() {
        ArrayList<Product> result = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idProduct = resultSet.getInt("idProduct");
                String nameProduct = resultSet.getString("nameProduct");
                double price = resultSet.getDouble("price");
                int amount = resultSet.getInt("amount");
                String image = resultSet.getString("image");
                Product product = new Product(idProduct, nameProduct, price, amount, image);
                result.add(product);
            }
            JDBCUtil.closeConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Product selectById(int id) {
        Product result = null;
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idProduct = resultSet.getInt("idProduct");
                String nameProduct = resultSet.getString("nameProduct");
                double price = resultSet.getDouble("price");
                int amount = resultSet.getInt("amount");
                String image = resultSet.getString("image");
                result = new Product(idProduct, nameProduct, price, amount,image);
            }
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Product> selectByCondition(String condition) {
        ArrayList<Product> result = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_CONDITION);
            preparedStatement.setString(1,condition);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idProduct = resultSet.getInt("idProduct");
                String nameProduct = resultSet.getString("nameProduct");
                double price = resultSet.getDouble("price");
                int amount = resultSet.getInt("amount");
                String image = resultSet.getString("image");
                Product product = new Product(idProduct, nameProduct, price, amount, image);
                result.add(product);
            }
            JDBCUtil.closeConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Product> selectByConditionID(int id) {
        String query =  "select idProduct, nameProduct, price, amount, image from Product where idProduct = ?;";
        ArrayList<Product> result = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idProduct = resultSet.getInt("idProduct");
                String nameProduct = resultSet.getString("nameProduct");
                double price = resultSet.getDouble("price");
                int amount = resultSet.getInt("amount");
                String image = resultSet.getString("image");
                Product product = new Product(idProduct, nameProduct, price, amount, image);
                result.add(product);
            }
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
