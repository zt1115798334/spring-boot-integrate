package com.example.springbootintegrate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class SpringBootIntegrateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootIntegrateApplication.class, args);
    }
}
