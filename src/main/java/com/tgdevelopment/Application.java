package com.tgdevelopment;

import com.tgdevelopment.services.ConnectionBuilder;
import com.tgdevelopment.services.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;

import static java.lang.System.exit;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.tgdevelopment")
//@EntityScan("com.tgdevelopment")
public class Application implements CommandLineRunner {

    @Autowired
    private ConnectionService connectionService;

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {

        Connection connection = connectionService.createConnection();
        connectionService.isConnectionValid(connection);

        connectionService.closeConnectin(connection);
        exit(0);
    }

}