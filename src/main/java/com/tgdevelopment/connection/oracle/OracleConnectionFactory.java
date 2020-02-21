package com.tgdevelopment.connection.oracle;

import com.tgdevelopment.configurations.SpringConfig;
import com.tgdevelopment.connection.AbstractConnectionFactory;
import com.tgdevelopment.connection.exceptions.ConnectionException;
import lombok.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

import static com.tgdevelopment.configurations.Databases.ORACLE;

@Value
public class OracleConnectionFactory implements AbstractConnectionFactory {

    DataSource dataSource;

    public OracleConnectionFactory() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        dataSource = context.getBean("OracleDataSource", DataSource.class);
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
