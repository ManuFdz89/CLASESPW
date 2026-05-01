package org.example.tiendafinal.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;

    public static Connection getConnection(){

        if(connection == null){
            createConnection();
        }

        return connection;
    }

    private static void createConnection()  {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/tienda_thpw_dam","root","root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
