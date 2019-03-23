package com.tgdevelopment.services;

import com.tgdevelopment.validation.ConnectorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.SQLRecoverableException;

import static java.lang.System.exit;

@Service
public class TestConnectionService {

    TestConnectionService() { }

    public void isConnectionValid(ConnectorValidator connectorValidator) throws SQLException {
        try {
            boolean isConncetionValid = connectorValidator.isConnectionValid();
            System.out.println("Connection created");
        } catch (SQLRecoverableException e) {
            System.out.println("Cannot create connection");
            exit(1);
        }
    }

}
