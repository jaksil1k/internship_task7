package com.example.task7.util;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public final class DBTables {


    private static final String METERS ="""
                CREATE TABLE IF NOT EXISTS meters(
                meter_id SERIAL PRIMARY KEY,
                meter_type VARCHAR(255) NOT NULL,
                meter_group VARCHAR(255) NOT NULL,
                meter_timestamp TIMESTAMP NOT NULL,
                current_reading double precision NOT NULL,
                CONSTRAINT fk_meter_group
                FOREIGN KEY(meter_group)
                REFERENCES meter_groups(name)
                );
                """;
    private static final String METER_GROUPS = """
                CREATE TABLE IF NOT EXISTS meter_groups(
                name VARCHAR(255) PRIMARY KEY
                )
                """;

    private static final String READINGS = """
                CREATE TABLE IF NOT EXISTS readings(
                id SERIAL PRIMARY KEY,
                meter_id SERIAL NOT NULL,
                reading double precision NOT NULL,
                date TIMESTAMP NOT NULL,
                CONSTRAINT fk_meter
                FOREIGN KEY(meter_id)
                REFERENCES meters(meter_id)
                )
                """;



    public static void createTables() throws SQLException {
        try (Connection connection = ConnectionManager.get();
             Statement statement = connection.createStatement()) {
            statement.execute(METER_GROUPS);
            statement.execute(METERS);
            statement.execute(READINGS);
            System.out.println("Database successfully started");
        }
    }
}
