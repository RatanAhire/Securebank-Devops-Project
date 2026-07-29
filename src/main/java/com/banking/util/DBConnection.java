package com.banking.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String DRIVER =
            "com.mysql.cj.jdbc.Driver";

    private static final String URL =
    "jdbc:mysql://localhost:3306/Securebank?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    private static final String USERNAME =
    "Securebank_user";

    private static final String PASSWORD =
    "Devil@20202020";
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