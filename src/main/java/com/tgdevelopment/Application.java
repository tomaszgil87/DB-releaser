package com.tgdevelopment;

import com.tgdevelopment.services.TestConnectionService;
import com.tgdevelopment.validation.OracleConnectionValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.SQLRecoverableException;

import static java.lang.System.exit;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.tgdevelopment")
//@EntityScan("com.tgdevelopment")
public class Application implements CommandLineRunner {

    @Autowired
    TestConnectionService testConnectionService;

    @Autowired
    OracleConnectionValidator oracleConnectionValidator;

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {

        testConnectionService.isConnectionValid(oracleConnectionValidator);

        exit(0);
    }

}