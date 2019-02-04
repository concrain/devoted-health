package com.devoted.health;

import com.devoted.health.utilities.CommandRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * Russel Arthur
 * Devoted Health Interview Application
 */
@SpringBootApplication
@Configuration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        context.getBean(CommandRunner.class).startConsole();
    }

}
