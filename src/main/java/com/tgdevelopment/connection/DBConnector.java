package com.tgdevelopment.connection;


import com.tgdevelopment.configurations.Databases;

import java.sql.Connection;

public interface DBConnector {

    boolean isValid();
    void close();
    Databases getDataBase();
    boolean equal(Databases databases);
    Connection getConnection();

}
