package com.tgdevelopment.services.connections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class OracleConnector implements DBConnector {

    @Autowired
    @Qualifier("OracleDataSource")
    private DataSource dataSource;

    public OracleConnector() {

    }

    @Override
    public boolean isConnectionValid() throws SQLException {
        return dataSource.getConnection().isValid(1);
    }

    @Override
    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    @Override
    public Connection createConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
