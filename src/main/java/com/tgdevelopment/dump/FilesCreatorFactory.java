package com.tgdevelopment.dump;

import com.tgdevelopment.connection.DBConnector;
import com.tgdevelopment.dump.oracle.OracleFilesCreator;

import static com.tgdevelopment.configurations.Databases.ORACLE;

public class FilesCreatorFactory {

    public static FilesCreator create(DBConnector connector) {
        if(connector.equal(ORACLE)) {
            return new OracleFilesCreator(connector);
        }

        return null;
    }

}
