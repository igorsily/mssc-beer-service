package com.igorsily.msscbeerservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.igorsily.msscbeerservice.bootstrap.BeerLoader;
import com.igorsily.msscbeerservice.model.BeerDTO;
import com.igorsily.msscbeerservice.model.BeerStyleEnum;
import com.igorsily.msscbeerservice.services.BeerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {


    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    BeerService beerService;

    @Test
    void getBeerById() throws Exception {

        given(this.beerService.getById(any())).willReturn(getValidBeerDTO());

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/beers/" + UUID.randomUUID())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveBeer() throws Exception {

        BeerDTO beerDTO = getValidBeerDTO();

        String beerJson = objectMapper.writeValueAsString(beerDTO);

        given(this.beerService.saveBeer(any())).willReturn(getValidBeerDTO());

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/beers/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerJson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeer() throws Exception {

        BeerDTO beerDTO = getValidBeerDTO();

        String beerJson = objectMapper.writeValueAsString(beerDTO);

        given(this.beerService.updateBeer(any(), any())).willReturn(getValidBeerDTO());

        mockMvc.perform(MockMvcRequestBuilders
                        .put("/api/v1/beers/" + UUID.randomUUID())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerJson))
                .andExpect(status().isNoContent());
    }

     BeerDTO getValidBeerDTO(){
        return  BeerDTO.builder()
                .beerName("MY BEER")
                .beerStyle(BeerStyleEnum.IPA)
                .price(new BigDecimal("11.99"))
                .upc(BeerLoader.BEER_1_UPC  )
                .build();
    }
}