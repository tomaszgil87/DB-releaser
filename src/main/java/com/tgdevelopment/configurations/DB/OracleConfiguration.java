package com.tgdevelopment.configurations.DB;

import oracle.jdbc.pool.OracleDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



import javax.sql.DataSource;
import java.sql.SQLException;


@Configuration
@ConfigurationProperties("oracle")
public class OracleConfiguration {

//    @NotNull
    private String username;

//    @NotNull
    private String password;

//    @NotNull
    private String url;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Bean(name = "OracleDataSource")
    public DataSource dataSource() throws SQLException {
        OracleDataSource oracleDataSource = new OracleDataSource();
        oracleDataSource.setUser(username);
        oracleDataSource.setPassword(password);
        oracleDataSource.setURL(url);

        return oracleDataSource;
    }

}
