package com.example.formula1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@ComponentScan("com.example.formula1")
//@SpringBootApplication(scanBasePackages={"com.example.formula1.db", "com.example.formula1.user"})

@SpringBootApplication
//@ComponentScan({"com.example.formula1.db", "com.example.formula1.user"})
//@EntityScan({"com.example.formula1.db", "com.example.formula1.user"})
//@EnableJpaRepositories({"com.example.formula1.db", "com.example.formula1.user"})
public class Formula1Application {

    public static void main(String[] args) {
        SpringApplication.run(Formula1Application.class, args);
    }
}
