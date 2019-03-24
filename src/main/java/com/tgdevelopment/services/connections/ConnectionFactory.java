package com.tgdevelopment.services.connections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConnectionFactory {

    @Autowired
    private OracleConnector oracleConnector;


    public DBConnector getConnector(String connector) {
        if (connector.equals(DbTypes.ORACLE.name())) {
            return oracleConnector;
        }

        return null;
    }

}
