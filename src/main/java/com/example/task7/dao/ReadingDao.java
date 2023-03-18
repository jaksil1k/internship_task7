package com.example.task7.dao;

import com.example.task7.entity.Reading;
import com.example.task7.util.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadingDao {

    private static final ReadingDao INSTANCE = new ReadingDao();

    private static final String SAVE_SQL = """
            INSERT INTO readings(meter_id, reading, date)
            VALUES(?, ?, ?)
            """;

    private ReadingDao() {}

    public static ReadingDao getInstance() {
        return INSTANCE;
    }


    public Reading create(Reading reading) {
        try (Connection connection = ConnectionManager.get();
             var prepareStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {

            prepareStatement.setLong(1, reading.getMeterId());
            prepareStatement.setDouble(2, reading.getReading());
            prepareStatement.setDate(3, reading.getDate());
            prepareStatement.executeUpdate();

            var result = prepareStatement.getGeneratedKeys();
            if (result.next()) {
                reading.setId(result.getLong("id"));
            }
            return reading;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
