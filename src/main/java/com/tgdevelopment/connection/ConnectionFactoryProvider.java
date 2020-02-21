package com.tgdevelopment.connection;

import com.tgdevelopment.configurations.Databases;
import com.tgdevelopment.connection.oracle.OracleConnectionFactory;

import java.util.Optional;

import static com.tgdevelopment.configurations.Databases.ORACLE;
import static java.util.Optional.of;


public class ConnectionFactoryProvider {

    public static Optional<AbstractConnectionFactory> getFactory(Databases database) {
        if(database.equals(ORACLE)) {
            return of(new OracleConnectionFactory());
        }
        return Optional.empty();
    }

}
