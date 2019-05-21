package com.tgdevelopment;

import com.tgdevelopment.model.oracle.DumpObjects;
import com.tgdevelopment.services.connections.ConnectionService;
import com.tgdevelopment.services.dump.DumpOracleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.util.List;

import static java.lang.System.exit;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.tgdevelopment")
//@EntityScan("com.tgdevelopment")
public class Application implements CommandLineRunner {

    @Autowired
    private ConnectionService connectionService;

    @Autowired
    private DumpOracleService dumpOracleService;

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {

        Connection connection = connectionService.createConnection("ORACLE");
        System.out.println("Connection created");

        List<DumpObjects> result = dumpOracleService.getDumpList(connection);

        connectionService.closeConnection(connection);
        exit(0);
    }

}