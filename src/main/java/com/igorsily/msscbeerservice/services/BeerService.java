package com.igorsily.msscbeerservice.services;

import com.igorsily.msscbeerservice.model.BeerDTO;

import java.util.UUID;

public interface BeerService {
    BeerDTO getById(UUID beerId);

    BeerDTO saveBeer(BeerDTO beerDTO);

    BeerDTO updateBeer(UUID beerId,BeerDTO beerDTO);
}
