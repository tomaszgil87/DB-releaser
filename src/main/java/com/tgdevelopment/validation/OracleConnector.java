package com.tgdevelopment.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.SQLException;

@Service
public class OracleConnector implements DBConnector {

    @Autowired
    private DataSource dataSource;

    public OracleConnector() {

    }

    @Override
    public boolean isConnectionValid() throws SQLException {
        return dataSource.getConnection().isValid(1);
    }

    @Override
    public void closeConnection() throws SQLException {
        //TODO
    }
}
