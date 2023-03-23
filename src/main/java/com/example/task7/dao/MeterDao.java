package com.example.task7.dao;

import com.example.task7.dto.MeterDto;
import com.example.task7.entity.Meter;
import com.example.task7.entity.MeterGroup;
import com.example.task7.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MeterDao {
    private static final MeterDao INSTANCE = new MeterDao();
    private static final String UPDATE_SQL = """
            update meters
            set date = ?,
            crrent_reading = ?,
            where meter_id = ?
            """;

    private MeterDao() {}

    public static MeterDao getInstance() {
        return INSTANCE;
    }

    private static final String SAVE_SQL = """
            INSERT INTO meters(meter_type, meter_group, meter_timestamp , current_reading, meter_id)
            VALUES(?, ?, ?, ?, ?)
            """;

    private static final String IS_PRESENT_SQL = """
            SELECT 1 FROM meters
            where meter_id=?
            """;

    private static final String FIND_ALL_BY_METER_GROUP = """
            select m.meter_id, m.meter_type,
            (select max(reading) from readings r where m.meter_id = r.meter_id),
            (select min(reading) from readings r where m.meter_id = r.meter_id),
            m.current_reading from meters m
            where m.meter_group = ?;
            """;

    public Meter create(Meter meter) {
        try (Connection connection = ConnectionManager.get();
             var prepareStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {

            prepareStatement.setString(1, meter.getType());
            prepareStatement.setString(2, meter.getMeterGroup());
            prepareStatement.setDate(3, meter.getTimestamp());
            prepareStatement.setDouble(4, meter.getCurrentReading());
            prepareStatement.setLong(5, meter.getMeterId());
            prepareStatement.executeUpdate();

            var result = prepareStatement.getGeneratedKeys();
            if (result.next()) {
                meter.setMeterId(result.getLong("meter_id"));
            }
            return meter;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isPresent(Long meterId) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement prepareStatement = connection.prepareStatement(IS_PRESENT_SQL)) {
            prepareStatement.setLong(1, meterId);

            ResultSet resultSet = prepareStatement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Meter meter) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement prepareStatement = connection.prepareStatement(UPDATE_SQL)) {
            prepareStatement.setDate(1, meter.getTimestamp());
            prepareStatement.setDouble(2, meter.getCurrentReading());
            prepareStatement.setLong(3, meter.getMeterId());

            prepareStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<MeterDto> getAllByMeterGroup(MeterGroup meterGroup) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement prepareStatement = connection.prepareStatement(FIND_ALL_BY_METER_GROUP)) {
            prepareStatement.setString(1, meterGroup.getName());

            ResultSet resultSet = prepareStatement.executeQuery();
            List<MeterDto> meterDtos = new ArrayList<>();
            while (resultSet.next()) {
                meterDtos.add(new MeterDto(
                        resultSet.getLong("meter_id"),
                        resultSet.getString("meter_type"),
                        resultSet.getDouble("max"),
                        resultSet.getDouble("min"),
                        resultSet.getDouble("current_reading")
                ));
            }
            return meterDtos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
