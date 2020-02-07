package com.tgdevelopment.connection.oracle;

import com.tgdevelopment.connection.exceptions.ConnectionException;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;

import static lombok.AccessLevel.PRIVATE;

@Repository
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class ConnectionValidator {

    public void isConnectionValid(Connection connection){
        try {
            connection.isValid(1);
            System.out.println("Connection created");
        } catch (SQLException e) {
            System.out.println("Cannot create connection");
            throw new ConnectionException(e.getMessage());
        }
    }

}
