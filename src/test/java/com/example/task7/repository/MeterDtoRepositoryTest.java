package com.example.task7.repository;


import com.example.task7.dto.MeterDto;
import com.example.task7.util.ConnectionManager;
import org.dbunit.Assertion;
import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


import java.io.FileInputStream;
import java.util.List;

public class MeterDtoRepositoryTest extends DatabaseTestCase {


    @Override
    protected IDatabaseConnection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        return new DatabaseConnection(ConnectionManager.get());
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(getClass().getClassLoader()
                .getResourceAsStream("data.xml"));
    }

    @BeforeEach
    protected void loadData() throws Exception {
        setUp();
    }


//    private final EntityManager em = Persistence.createEntityManagerFactory("DBUnitEx").createEntityManager();


//    @Before
//    public void setUp() throws Exception {
//        super.setUp();
//        beforeData = new FlatXmlDataSetBuilder().build(
//                Thread.currentThread().getContextClassLoader()
//                        .getResourceAsStream("classpath:/data.xml"));
//
//        tester.setDataSet(beforeData);
//        tester.onSetup();
//    }

    @Test
    public void testGetAll() throws Exception {
        IDataSet expectedDataSet = getDataSet();
        ITable expectedTable = expectedDataSet.getTable("METERS");
        IDataSet databaseDataSet = getConnection().createDataSet();
        ITable actualTable = databaseDataSet.getTable("METERS");

        assertThat(expectedTable.getRowCount()).isEqualTo(actualTable.getRowCount());

    }

}
