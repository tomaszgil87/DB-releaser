package com.tgdevelopment.connection;

import com.tgdevelopment.configurations.Databases;
import com.tgdevelopment.connection.oracle.OracleConnectionFactory;

import static com.tgdevelopment.configurations.Databases.ORACLE;


public class ConnectionFactoryProvider {

    public static AbstractConnectionFactory getFactory(Databases database) {
        if(database.equals(ORACLE)) {
            return new OracleConnectionFactory();
        }
        return null;
    }

}
