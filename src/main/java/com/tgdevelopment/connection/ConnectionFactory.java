package com.tgdevelopment.connection;

import com.tgdevelopment.configurations.Databases;
import com.tgdevelopment.connection.exceptions.ConnectionException;
import com.tgdevelopment.connection.oracle.OracleConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;


@Repository
public class ConnectionFactory {

    @Autowired
    @Qualifier("OracleDataSource")
    private DataSource dataSource;

    public DBConnector create(Databases database) {
        if (database.equals("ORACLE")) {
            try {
                return new OracleConnector(dataSource.getConnection(), database);
            } catch (SQLException e) {
                throw new ConnectionException(e.getMessage());
            }
        }
        return null;
    }

}
