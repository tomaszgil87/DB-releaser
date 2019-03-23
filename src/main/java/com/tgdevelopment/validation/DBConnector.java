package com.tgdevelopment.validation;

import java.sql.SQLException;

public interface DBConnector {

    boolean isConnectionValid() throws SQLException;

    void closeConnection() throws SQLException;

}
