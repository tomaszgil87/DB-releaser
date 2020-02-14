package com.tgdevelopment.dump.oracle;

import com.tgdevelopment.connection.DBConnector;
import com.tgdevelopment.dump.FilesCreator;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class OracleFilesCreator implements FilesCreator {

    DBConnector connector;

    @Override
    public void dump() {

    }
}
