package com.tgdevelopment.databases;

import com.tgdevelopment.connection.DBConnector;
import com.tgdevelopment.databases.oracle.OracleObjectsCreator;

import java.util.Optional;

import static com.tgdevelopment.configurations.Databases.ORACLE;
import static java.util.Optional.empty;
import static java.util.Optional.of;

public class ObjectsCreatorFactory {

    public static Optional<ObjectsCreator> create(DBConnector connector) {
        Optional<ObjectsCreator> creator = empty();
        if(connector.equal(ORACLE)) {
            creator = of(new OracleObjectsCreator(connector));
        }

        return creator;
    }

}
