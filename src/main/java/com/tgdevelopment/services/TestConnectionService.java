package com.tgdevelopment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.SQLException;

@Service
public class TestConnectionService {

    @Autowired
    DataSource dataSource;

    TestConnectionService() { }

    public boolean testOracleConnection() throws SQLException {
        if (dataSource.getConnection().isValid(1)) {
            return true;
        } else {
            return false;
        }
    }

}
