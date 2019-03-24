package com.tgdevelopment.services.connections;


import java.sql.Connection;
import java.sql.SQLException;

public interface DBConnector {

    boolean isConnectionValid() throws SQLException;

    void closeConnection(Connection connection) throws SQLException;

    Connection createConnection() throws SQLException;

}
