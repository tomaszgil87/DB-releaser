package com.tgdevelopment.services.connections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;

@Service
public class ConnectionBuilder {

    private ConnectionFactory connectionFactory;

    @Autowired
    public ConnectionBuilder(ConnectionFactory connectionFactory){
        this.connectionFactory = connectionFactory;
    }

    public Connection createConnection(String database) throws SQLException {
        DBConnector dbConnector = connectionFactory.getConnector(database);

        return dbConnector.createConnection();
    }

}
