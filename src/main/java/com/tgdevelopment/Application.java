package com.tgdevelopment;

import com.tgdevelopment.services.TestConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

import static java.lang.System.exit;
import static java.lang.System.setOut;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.tgdevelopment")
@EntityScan("com.tgdevelopment")
public class Application implements CommandLineRunner {

    @Autowired
    TestConnectionService testConnectionService;

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Test");
        System.out.println(testConnectionService.testOracleConnection());

        exit(0);
    }

}