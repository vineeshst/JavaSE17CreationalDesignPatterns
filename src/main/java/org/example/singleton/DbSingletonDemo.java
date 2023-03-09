package org.example.singleton;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class DbSingletonDemo {
    public static void main(String[] args) throws SQLException {
        DbSingleton instance = DbSingleton.getInstance();
        System.out.println(instance);

        Connection conn = instance.getConnection();

        Statement statement = conn.createStatement();
        statement.execute("Create table students (ID int primary key, name varchar(65))");
        System.out.println("Created table students");
        int rows = statement.executeUpdate("INSERT INTO students (ID, name) values (1, 'Vineesh')");
        if (rows > 0)
            System.out.println("Inserted a new row.");
        conn.close();

    }
}
