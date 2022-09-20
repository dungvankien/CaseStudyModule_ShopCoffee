package shopcoffee.service;

import shopcoffee.model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountService {
    public Account login (String user, String pass){
        Account result = null;
        String query = "SELECT * FROM caseshopcoffee.account where username = ? and password = ? ;";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,user);
            preparedStatement.setString(2,pass);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("idAccount");
                String username =  resultSet.getString("username");
                String password = resultSet.getString("password");
                int limitAccount = resultSet.getInt("limitAccount");
                result = new Account(id,username,password,limitAccount);
                JDBCUtil.closeConnection(connection);
                return result;
            }
            JDBCUtil.closeConnection(connection);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

}
