package com.example.task7.dao;

import com.example.task7.entity.MeterGroup;
import com.example.task7.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MeterGroupDao {

    private static final MeterGroupDao INSTANCE = new MeterGroupDao();
    private static final String SAVE_SQL = "insert into meter_groups values(?)";


    private static final String IS_PRESENT_SQL = """
            SELECT 1 FROM meter_groups
            where name=?
            """;


    private static final String FIND_ALL_SQL = """
            SELECT name FROM meter_groups
            """;

    private MeterGroupDao() {}

    public static MeterGroupDao getInstance() {
        return INSTANCE;
    }


    public boolean isPresent(String meterGroup) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement prepareStatement = connection.prepareStatement(IS_PRESENT_SQL)) {
            prepareStatement.setString(1, meterGroup);

            ResultSet resultSet = prepareStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void create(String meterGroup) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement prepareStatement = connection.prepareStatement(SAVE_SQL)) {
            prepareStatement.setString(1, meterGroup);

            prepareStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<MeterGroup> getAll() {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement prepareStatement = connection.prepareStatement(FIND_ALL_SQL)) {

            ResultSet resultSet = prepareStatement.executeQuery();
            List<MeterGroup> meterGroups = new ArrayList<>();
            while (resultSet.next()) {
                meterGroups.add(new MeterGroup(
                        resultSet.getString("name")
                ));
            }
            return meterGroups;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
