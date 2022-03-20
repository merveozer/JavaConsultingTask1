
package net.javaguides.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import net.javaguides.registration.model.User;

public class UserDao {
    public int kullaniciKayit(User user)throws ClassNotFoundException{
        String INSERT_USERS_SQL = "INSERT INTO users" + 
                "(id, username,password) VALUES" +
                "(?,?,?);";
        
        int result = 0;
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kullanici?useSSL=false", "root", "12345");
        
          PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
          preparedStatement.setInt(1,1);
          preparedStatement.setString(2, user.getUsername());
          preparedStatement.setString(3,user.getPassword());
          
          System.out.println(preparedStatement);
          result = preparedStatement.executeUpdate();
        }catch (SQLException e){
                e.printStackTrace();
                } 
        return result;
                
    }

    public void registerUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
}
