package com.tgdevelopment.dump;

import com.tgdevelopment.connection.DBConnector;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class FilesCreatorImpl implements FilesCreator {

    DBConnector connector;

    @Override
    public void dump() {

    }
}
