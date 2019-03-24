package com.tgdevelopment.services.connections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLRecoverableException;

import static java.lang.System.exit;

@Service
public class ConnectionService {

    private ConnectionBuilder connectionBuilder;

    @Autowired
    ConnectionService(ConnectionBuilder connectionBuilder) {
        this.connectionBuilder = connectionBuilder;
    }

    public Connection createConnection(String database) throws SQLException{
        return connectionBuilder.createConnection(database);
    }

    public void isConnectionValid(Connection connection) throws SQLException {
        try {
            boolean isConncetionValid = connection.isValid(1);
            System.out.println("Connection created");
        } catch (SQLRecoverableException e) {
            System.out.println("Cannot create connection");
            exit(1);
        }
    }

    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
        System.out.println("Connection closed");
    }

}
