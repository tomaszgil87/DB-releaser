package com.tgdevelopment;

import com.tgdevelopment.controllers.DbController;
import com.tgdevelopment.services.connections.ConnectionService;
import com.tgdevelopment.services.dump.DumpService;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class Application implements CommandLineRunner {

    private final ConnectionService connectionService;
    private final DbController dbController;

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {

        Connection connection = connectionService.createConnection("ORACLE");
        System.out.println("Connection created");

        dbController.dumpFiles("test");

        connectionService.closeConnection(connection);
        exit(0);
    }

}