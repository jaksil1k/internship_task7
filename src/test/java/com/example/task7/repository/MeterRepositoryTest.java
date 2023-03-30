package com.example.task7.repository;

import com.example.task7.config.DBUnitConfig;
import com.example.task7.dto.MeterDto;
import com.example.task7.repository.MeterDtoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import org.dbunit.Assertion;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MeterRepositoryTest extends DBUnitConfig {


    @Autowired
    private MeterDtoRepository meterRepository;

//    private final EntityManager em = Persistence.createEntityManagerFactory("DBUnitEx").createEntityManager();

    public MeterRepositoryTest(String name) {
        super(name);
    }

    public MeterRepositoryTest(String name, MeterDtoRepository meterRepository) {
        super(name);
        this.meterRepository = meterRepository;
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        beforeData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("classpath:/data.xml"));

        tester.setDataSet(beforeData);
        tester.onSetup();
    }

    @Test
    public void testGetAll() throws Exception {
        List<MeterDto> meters = meterRepository.getAllByMeterGroup("room1");

        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("classpath:/data.xml"));

        IDataSet actualData = tester.getConnection().createDataSet();
        Assertion.assertEquals(expectedData, actualData);
        Assert.assertEquals(expectedData.getTable("meters").getRowCount(),meters.size());
    }

}
