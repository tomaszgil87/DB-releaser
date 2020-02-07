package com.tgdevelopment.connection;

import com.tgdevelopment.configurations.Databases;
import com.tgdevelopment.connection.oracle.ConnectionValidator;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.sql.Connection;

import static lombok.AccessLevel.PRIVATE;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class ConnectionService {

    ConnectionFactory connectionFactory;
    ConnectionValidator connectionValidator;

    public DBConnector createConnection(Databases database){
        return connectionFactory.create(database);
    }

    public void isConnectionValid(Connection connection){
        connectionValidator.isConnectionValid(connection);
    }

//    public void closeConnection(Connection connection){
//        connectionFactory.close(connection);
//    }

}
