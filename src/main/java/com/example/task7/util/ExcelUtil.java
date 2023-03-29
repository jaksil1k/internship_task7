package com.example.task7.util;

import com.example.task7.entity.Meter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {
    public static List<Meter> readFromExcel(String file) throws IOException {
        List<Meter> meters = new ArrayList<>();

        Workbook workbook = new XSSFWorkbook(new FileInputStream(file));
        for (int i = 0;i < workbook.getNumberOfSheets();i++) {
            Sheet sheet = workbook.getSheetAt(i);
            for (Row row : sheet) {
                Meter meter = new Meter();
                meter.setMeterId((long) row.getCell(0).getNumericCellValue());
                meter.setMeterType(row.getCell(1).getStringCellValue());
                meter.setMeterGroup(row.getCell(2).getStringCellValue());
                meter.setTimestamp(new Date(row.getCell(3).getDateCellValue().getTime()));
                meter.setCurrentReading(row.getCell(4).getNumericCellValue());
                meters.add(meter);
            }
        }
        return meters;
    }
}
