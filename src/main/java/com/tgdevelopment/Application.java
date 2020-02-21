package com.tgdevelopment;

import com.tgdevelopment.configurations.Databases;
import com.tgdevelopment.connection.ConnectionService;
import com.tgdevelopment.connection.DBConnector;
import com.tgdevelopment.databases.DatabaseService;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.System.exit;
import static lombok.AccessLevel.PRIVATE;

@SpringBootApplication
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class Application implements CommandLineRunner {

    ConnectionService connectionService;
    DatabaseService databaseService;

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