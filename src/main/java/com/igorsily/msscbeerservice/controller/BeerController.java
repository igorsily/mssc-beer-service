package com.igorsily.msscbeerservice.controller;

import com.igorsily.msscbeerservice.model.BeerDTO;
import com.igorsily.msscbeerservice.services.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/beers")
public class BeerController {

    private final BeerService beerService;

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDTO> getBeerById(@PathVariable("beerId") UUID beerId) {
        BeerDTO beerDTO = this.beerService.getById(beerId);
        return new ResponseEntity<>(beerDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDTO> saveBeer(@Validated @RequestBody BeerDTO beerDTO) {
        BeerDTO beerSave = this.beerService.saveBeer(beerDTO);
        return new ResponseEntity<>(beerSave,HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<Void> updateBeer(@PathVariable("beerId") UUID beerId, @Validated @RequestBody BeerDTO beerDTO) {
        this.beerService.updateBeer(beerId, beerDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
