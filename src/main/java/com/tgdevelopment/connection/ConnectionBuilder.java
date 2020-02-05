package com.tgdevelopment.connection;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;

@Service
@AllArgsConstructor
public class ConnectionBuilder {

    private final ConnectionFactory connectionFactory;

    public Connection createConnection(String database) throws SQLException {
        DBConnector dbConnector = connectionFactory.getConnector(database);

        return dbConnector.createConnection();
    }

}
