package com.tgdevelopment.validation;

import java.sql.SQLException;

public interface ConnectorValidator {

    boolean isConnectionValid() throws SQLException;

}
