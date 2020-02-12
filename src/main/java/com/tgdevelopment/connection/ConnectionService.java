package com.tgdevelopment.connection;

import com.tgdevelopment.configurations.Databases;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import static com.tgdevelopment.connection.ConnectionFactoryProvider.getFactory;
import static lombok.AccessLevel.PRIVATE;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class ConnectionService {

    public DBConnector createConnection(Databases database){
        return getFactory(database).create();
    }

}
