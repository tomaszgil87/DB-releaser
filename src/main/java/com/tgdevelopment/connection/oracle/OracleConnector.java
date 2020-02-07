package com.tgdevelopment.connection.oracle;

import com.tgdevelopment.connection.DBConnector;
import com.tgdevelopment.connection.exceptions.ConnectionException;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static lombok.AccessLevel.PRIVATE;

@Component
@FieldDefaults(level = PRIVATE)
public class OracleConnector implements DBConnector {

    @Autowired
    @Qualifier("OracleDataSource")
    DataSource dataSource;

    @Setter
    Connection connection;

    public OracleConnector(Connection connection) {
        this.connection = connection;
    }

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

    @Override
    public void create() {
        try {
            setConnection(dataSource.getConnection());
        } catch(SQLException e) {
            throw new ConnectionException(e.getMessage());
        }
    }
}
