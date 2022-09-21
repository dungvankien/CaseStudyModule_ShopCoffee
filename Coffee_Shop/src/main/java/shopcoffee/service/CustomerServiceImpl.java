package shopcoffee.service;

import shopcoffee.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerServiceImpl implements DaoInterface<Customer> {

    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO Customer (nameCustomer, email, phone, address) VALUES (?, ?, ?, ?);";
    private static final String SELECT_CUSTOMER_BY_ID = "select idCustomer, nameCustomer, email, phone, address from Customer where idCustomer = ?";
    private static final String SELECT_ALL_CUSTOMER = "select * from Customer";
    private static final String DELETE_CUSTOMER_SQL = "delete from Customer where idCustomer = ?;";
    private static final String UPDATE_CUSTOMER_SQL = "update Customer set nameCustomer = ?,email= ?, phone =  ?, address = ? where idCustomer = ?;";
    private static final String SELECT_CUSTOMER_BY_CONDITION = "select idCustomer, nameCustomer, email, phone, address from Customer where nameCustomer = ?;";
    public boolean checkPhoneEdit (int id, String phone) {
        String query = "SELECT * FROM caseshopcoffee.customer where idCustomer != ? and phone = ? ;";
        Connection connection = JDBCUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, phone);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                JDBCUtil.closeConnection(connection);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtil.closeConnection(connection);
        return false;
    }
    public boolean checkEmailEdit (int id, String email) {
        String query = "SELECT * FROM caseshopcoffee.customer where idCustomer != ? and email = ? ;";
        Connection connection = JDBCUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                JDBCUtil.closeConnection(connection);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtil.closeConnection(connection);
        return false;
    }
    public boolean checkPhone(String phone){
        String query = "SELECT * FROM caseshopcoffee.customer where phone  = ?;";
        Connection connection = JDBCUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, phone);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                JDBCUtil.closeConnection(connection);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtil.closeConnection(connection);
        return false;
    }

    public boolean checkEmail(String email) {
        String query = "SELECT * FROM caseshopcoffee.customer where email = ?;";
        Connection connection = JDBCUtil.getConnection();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                JDBCUtil.closeConnection(connection);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtil.closeConnection(connection);
        return false;
    }
    @Override
    public int insert(Customer customer) {
        int result=0;
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL);
            preparedStatement.setString(1, customer.getNameCustomer());
            preparedStatement.setString(2, customer.getEmail());
            preparedStatement.setString(3, customer.getPhone());
            preparedStatement.setString(4,customer.getAddress());
            result = preparedStatement.executeUpdate();
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(Customer customer) {
        int result = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_SQL);
            preparedStatement.setString(1, customer.getNameCustomer());
            preparedStatement.setString(2,customer.getEmail());
            preparedStatement.setString(3, customer.getPhone());
            preparedStatement.setString(4, customer.getAddress());
            preparedStatement.setInt(5,customer.getIdCustomer());
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
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER_SQL);
            preparedStatement.setInt(1,id);
            result = preparedStatement.executeUpdate();
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Customer> selectAll() {
        ArrayList<Customer> result = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idCustomer = resultSet.getInt("idCustomer");
                String nameCustomer = resultSet.getString("nameCustomer");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                Customer customer = new Customer(idCustomer, nameCustomer, email, phone, address);
                result.add(customer);
            }
            JDBCUtil.closeConnection(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Customer selectById(int id) {
        Customer result = null;
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idCustomer = resultSet.getInt("idCustomer");
                String nameCustomer = resultSet.getString("nameCustomer");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                result = new Customer(idCustomer, nameCustomer, email, phone, address);
            }
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Customer> selectByCondition(String condition) {
        ArrayList<Customer> result = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_CONDITION);
            preparedStatement.setString(1,condition);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idCustomer = resultSet.getInt("idCustomer");
                String nameCustomer = resultSet.getString("nameCustomer");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                Customer customer = new Customer(idCustomer, nameCustomer, email, phone, address);
                result.add(customer);
            }
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Customer> selectByConditionID(int id) {
        String query = "select idCustomer, nameCustomer, email, phone, address from Customer where idCustomer = ?;";
        ArrayList<Customer> result = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idCustomer = resultSet.getInt("idCustomer");
                String nameCustomer = resultSet.getString("nameCustomer");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                Customer customer = new Customer(idCustomer, nameCustomer, email, phone, address);
                result.add(customer);
            }
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
