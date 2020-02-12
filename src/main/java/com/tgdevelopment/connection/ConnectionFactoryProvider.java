package com.tgdevelopment.connection;

import com.tgdevelopment.configurations.Databases;
import com.tgdevelopment.connection.oracle.OracleConnectionFactory;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import static com.tgdevelopment.configurations.Databases.ORACLE;
import static lombok.AccessLevel.PRIVATE;

@Component
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class ConnectionFactoryProvider {

    public static AbstractConnectionFactory getFactory(Databases database) {
        if(database.equals(ORACLE)) {
            return new OracleConnectionFactory();
        }
        return null;
    }

}
