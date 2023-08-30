package org.example;

import org.example.domain.Author;
import org.example.repository.AuthorRepository;
import org.example.service.LibDemoService;
import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);

        context.getBean(LibDemoService.class).bookDemo();

        context.close();

        /*// запуск консоли H2
        try {
            Console.main(args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
    }
}