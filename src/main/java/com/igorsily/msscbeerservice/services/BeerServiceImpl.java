package com.igorsily.msscbeerservice.services;

import com.igorsily.msscbeerservice.controller.NotFoundException;
import com.igorsily.msscbeerservice.domain.Beer;
import com.igorsily.msscbeerservice.mappers.BeerMapper;
import com.igorsily.msscbeerservice.model.BeerDTO;
import com.igorsily.msscbeerservice.repository.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;

    private final BeerMapper beerMapper;

    @Override
    public BeerDTO getById(UUID beerId) {


       Beer beer = this.beerRepository.findById(beerId).orElseThrow(NotFoundException::new);

        return this.beerMapper.BeerToBeerDTO(beer);
    }

    @Override
    public BeerDTO saveBeer(BeerDTO beerDTO) {

        Beer beer = this.beerRepository.save(this.beerMapper.BeerDTOToBeer(beerDTO));
        return this.beerMapper.BeerToBeerDTO(beer);

    }

    @Override
    public BeerDTO updateBeer(UUID beerId, BeerDTO beerDTO) {

        Beer beer = this.beerRepository.findById(beerId).orElseThrow(NotFoundException::new);

        //TODO implementar o update

        return  null;
    }
}
