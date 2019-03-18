package com.tgdevelopment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

import static java.lang.System.exit;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.tgdevelopment")
public class Application implements CommandLineRunner {

    @Autowired
    DataSource dataSource;

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Test");
        System.out.println("Data source: " + dataSource);

        exit(0);
    }

}