package com.federation.datasource;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

@Component("customDataSourceHelper")
@RequiredArgsConstructor
public class DataSource {

    private final javax.sql.DataSource dataSource;

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Impossible d'obtenir une connexion depuis le pool Spring", e);
        }
    }
}
