package com.igorsily.msscbeerservice.mappers;

import com.igorsily.msscbeerservice.domain.Beer;
import com.igorsily.msscbeerservice.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDTO BeerToBeerDTO(Beer beer);

    Beer BeerDTOToBeer(BeerDTO beerDTO);

}
