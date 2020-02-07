package com.tgdevelopment;

import com.tgdevelopment.configurations.Databases;
import com.tgdevelopment.connection.DBConnector;
import com.tgdevelopment.dump.DbController;
import com.tgdevelopment.connection.ConnectionService;
import lombok.AllArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
    public void run(String... args) {

        DBConnector connector = connectionService.createConnection(Databases.ORACLE);
        System.out.println("Connection created");

        dbController.dumpFiles("test");

        connector.close();
        exit(0);
    }

}