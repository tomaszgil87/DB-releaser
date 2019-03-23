package com.tgdevelopment.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.SQLException;

@Service
public class OracleConnectionValidator implements ConnectorValidator {

    @Autowired
    DataSource dataSource;

    public OracleConnectionValidator() {

    }

    @Override
    public boolean isConnectionValid() throws SQLException {
        return dataSource.getConnection().isValid(1);
    }
}
