package com.tgdevelopment.databases;

import com.tgdevelopment.connection.DBConnector;
import com.tgdevelopment.databases.oracle.OracleObjectsCreator;

import java.util.Optional;

import static com.tgdevelopment.configurations.Databases.ORACLE;
import static java.util.Optional.ofNullable;

public class ObjectsCreatorFactory {

    public static Optional<ObjectsCreator> create(DBConnector connector) {
        ObjectsCreator creator = null;
        if(connector.equal(ORACLE)) {
            creator = new OracleObjectsCreator(connector);
        }

        return ofNullable(creator);
    }

}
