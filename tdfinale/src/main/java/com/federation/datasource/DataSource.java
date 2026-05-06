package com.federation.datasource;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component("customDataSourceHelper")
public class DataSource {

    public Connection getConnection() {
        try {
            String jdbcURl = "jdbc:h2:mem:federation_db;DB_CLOSE_DELAY=-1";
            String user = "sa";
            String password = "";
            return DriverManager.getConnection(jdbcURl, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
