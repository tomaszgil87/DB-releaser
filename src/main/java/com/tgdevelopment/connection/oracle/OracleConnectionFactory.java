package com.tgdevelopment.connection.oracle;

import com.tgdevelopment.configurations.SpringConfig;
import com.tgdevelopment.connection.AbstractConnectionFactory;
import com.tgdevelopment.connection.exceptions.ConnectionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

import static com.tgdevelopment.configurations.Databases.ORACLE;

public class OracleConnectionFactory implements AbstractConnectionFactory {

    ApplicationContext context =
            new AnnotationConfigApplicationContext(SpringConfig.class);

    private DataSource dataSource;

    public OracleConnectionFactory() {
        dataSource = (DataSource) context.getBean("OracleDataSource");
    }

    @Override
    public OracleConnector create() {
        try {
            return new OracleConnector(dataSource.getConnection(), ORACLE);
        } catch (SQLException e) {
            throw new ConnectionException(e.getMessage());
        }
    }
}
