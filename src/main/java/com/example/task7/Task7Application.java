package com.example.task7;

import com.example.task7.util.DBTables;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;

import java.sql.SQLException;

@SpringBootApplication
public class Task7Application {

    public static void main(String[] args) {
//        try {
//            DBTables.createTables();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        SpringApplication.run(Task7Application.class, args);
    }

}
