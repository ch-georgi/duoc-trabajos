
package com.gccg.soundscape;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Genesis C - Christopher G
 * https://www.sqliz.com/posts/java-connect-mysql8-maven/
 */
public class DatabaseConnection {
    
     public static Connection getConnection() {
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/musicdb";
            //String url = "jdbc:mysql://localhost:3308/musicdb"; //casa
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
        return connection;
    }
}
