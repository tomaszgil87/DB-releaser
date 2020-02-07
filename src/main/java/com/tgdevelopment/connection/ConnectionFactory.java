package com.tgdevelopment.connection;

import com.tgdevelopment.configurations.Databases;
import com.tgdevelopment.connection.oracle.OracleConnector;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import static com.tgdevelopment.configurations.Databases.ORACLE;
import static lombok.AccessLevel.PRIVATE;

@Repository
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class ConnectionFactory {

    OracleConnector oracleConnector;

    public DBConnector create(Databases database) {
        if (database.equals(ORACLE)) {
            return oracleConnector;
        }
        return null;
    }

}
