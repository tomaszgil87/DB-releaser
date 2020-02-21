package com.tgdevelopment.connection;

import com.tgdevelopment.configurations.Databases;
import com.tgdevelopment.connection.exceptions.ConnectionException;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import static com.tgdevelopment.connection.ConnectionFactoryProvider.getFactory;
import static java.util.Optional.ofNullable;
import static lombok.AccessLevel.PRIVATE;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class ConnectionService {

    public DBConnector createConnection(Databases database){
        return ofNullable(getFactory(database))
                .orElseThrow(() -> new ConnectionException("Cannot create connection to " + database.getValue()))
                .create();
    }

}
