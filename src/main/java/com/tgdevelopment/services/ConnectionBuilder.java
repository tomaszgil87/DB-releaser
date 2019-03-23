package com.tgdevelopment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Service
public class ConnectionBuilder {

    @Autowired
    private DataSource dataSource;

    public Connection createConnection() throws SQLException {
        return dataSource.getConnection();
    }

}
