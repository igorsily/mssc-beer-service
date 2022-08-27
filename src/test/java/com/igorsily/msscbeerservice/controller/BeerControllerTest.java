package com.igorsily.msscbeerservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.igorsily.msscbeerservice.model.Beer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeerById() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/beers/" + UUID.randomUUID())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveBeer() throws Exception {

        Beer beer = Beer.builder().build();

        String beerJson = objectMapper.writeValueAsString(beer);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/beers/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerJson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeer() throws Exception {

        Beer beer = Beer.builder().build();

        String beerJson = objectMapper.writeValueAsString(beer);


        mockMvc.perform(MockMvcRequestBuilders
                        .put("/api/v1/beers/" + UUID.randomUUID())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerJson))
                .andExpect(status().isNoContent());
    }
}