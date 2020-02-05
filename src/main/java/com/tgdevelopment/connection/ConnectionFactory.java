package com.tgdevelopment.connection;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ConnectionFactory {

    private final OracleConnector oracleConnector;

    public DBConnector getConnector(String connector) {
        if (connector.equals(DbTypes.ORACLE.name())) {
            return oracleConnector;
        }

        return null;
    }

}
