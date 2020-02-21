package com.tgdevelopment;

import com.tgdevelopment.configurations.Databases;
import com.tgdevelopment.connection.ConnectionService;
import com.tgdevelopment.connection.DBConnector;
import com.tgdevelopment.databases.DatabaseService;
import lombok.AllArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.System.exit;

@SpringBootApplication
@AllArgsConstructor
public class Application implements CommandLineRunner {

    private final ConnectionService connectionService;
    private final DatabaseService databaseService;

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... args) {

        DBConnector connector = connectionService.createConnection(Databases.ORACLE);
        System.out.println("Connection created");

        databaseService.dump(connector);

        connector.close();
        exit(0);
    }

}