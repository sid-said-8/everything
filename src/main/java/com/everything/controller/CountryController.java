package com.everything.controller;


import com.everything.entity.Country;
import com.everything.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/country")
public class CountryController {

    private CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping("/addCountry")
    public ResponseEntity<Country>addCountry(@RequestBody Country country){
        Country savedCountry = countryService.addCountry(country);
        return new ResponseEntity<>(savedCountry, HttpStatus.CREATED);
    }

    @GetMapping("/allCountry")
    public ResponseEntity<List<Country>>getAllCountry(Country country){
        List<Country> allCountry = countryService.getAllCountry(country);
        return new ResponseEntity<>(allCountry,HttpStatus.OK);
    }






}
