package com.tgdevelopment.connection.oracle;

import com.tgdevelopment.configurations.Databases;
import com.tgdevelopment.connection.DBConnector;
import com.tgdevelopment.connection.exceptions.ConnectionException;
import lombok.Value;
import lombok.experimental.FieldDefaults;

import java.sql.Connection;
import java.sql.SQLException;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE, makeFinal = true)
@Value
public class OracleConnector implements DBConnector {

    Connection connection;
    Databases database;

    @Override
    public boolean isValid() {
        try {
            return connection.isValid(1);
        } catch(SQLException e) {
            throw new ConnectionException(e.getMessage());
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch(SQLException e) {
            throw new ConnectionException(e.getMessage());
        }
    }

}
