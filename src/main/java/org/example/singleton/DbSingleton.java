package org.example.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbSingleton {
    private Connection conn = null;

    private static class LazyHolder{
        static final DbSingleton INSTANCE = new DbSingleton();
    }
    private DbSingleton() {
        String jdbcURL = "jdbc:h2:mem:test";
        try {
            conn = DriverManager.getConnection(jdbcURL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static DbSingleton getInstance(){
        return LazyHolder.INSTANCE;
    }
    public Connection getConnection(){
        return conn;
    }
}
