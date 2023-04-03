package com.example.task7.controller;


import com.example.task7.entity.Meter;
import com.example.task7.service.MeterGroupService;
import com.example.task7.service.MeterService;
import com.example.task7.service.ReadingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.sql.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest(MeterApiController.class)
class MeterApiControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private MeterService meterService;

    @MockBean
    private MeterGroupService meterGroupService;

    @MockBean
    private ReadingService readingService;

    @Test
    public void meterReading() throws Exception {
        String json = "{\"meterId\": 123, \"type\": \"ELM777\", \"meterGroup\": \"room1\", \"timestamp\": \"2022-10-26T10:55:00.000Z\", \"currentReading\": 125.67}";

        Meter meter = new Meter(123L, "ELM777", "room1", new Date(123), 125.67);

        given(meterService.create(any())).willReturn(meter);


        this.mockMvc.perform(post("http://localhost:8081/api/v1.0/meters")
                        .content(asJsonString(meter))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.meterId").exists());
    }

    @Test
    public void  getReport() throws Exception {

        this.mockMvc
                .perform(get("http://localhost:8080/api/v1.0/meters/report"))
                .andDo(print()).andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
