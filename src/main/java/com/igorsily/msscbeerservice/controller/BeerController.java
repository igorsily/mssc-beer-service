package com.igorsily.msscbeerservice.controller;

import com.igorsily.msscbeerservice.model.Beer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beers")
public class BeerController {

    @GetMapping("/{beerId}")
    public ResponseEntity<Beer> getBeerById(@PathVariable("beerId") UUID beerId) {

        return new ResponseEntity<>(Beer.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> saveBeer(@RequestBody Beer beer) {

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<Void> updateBeer(@PathVariable("beerId") UUID beerId, @RequestBody Beer beer) {

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
