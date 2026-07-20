package com.securebank.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String DRIVER =
            "com.mysql.cj.jdbc.Driver";

    private static final String URL =
            "jdbc:mysql://localhost:3306/securebank_db?useSSL=false&serverTimezone=UTC";

    private static final String USERNAME =
            "root";

    private static final String PASSWORD =
            "root";

    private DBConnection() {

    }

    public static Connection getConnection() {

        Connection connection = null;

        try {

            Class.forName(DRIVER);

            connection = DriverManager.getConnection(
                    URL,
                    USERNAME,
                    PASSWORD
            );

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return connection;

    }

    public static void close(Connection connection) {

        if (connection != null) {

            try {

                connection.close();

            } catch (SQLException e) {

                e.printStackTrace();

            }

        }

    }

}