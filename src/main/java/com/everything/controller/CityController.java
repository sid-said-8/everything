package com.everything.controller;


import com.everything.entity.City;
import com.everything.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/city")
public class CityController {

    private CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/addCity")
    public ResponseEntity<City>addcity(@RequestParam long countryId,@RequestBody City city){
        City savedCity = cityService.addCity(countryId,city);
        return new ResponseEntity<>(savedCity, HttpStatus.CREATED);
    }

    @GetMapping("/allCity")
    public ResponseEntity<List<City>>getAllcity(City city){
        List<City> allCity = cityService.getAllcity(city);
        return new ResponseEntity<>(allCity,HttpStatus.OK);
    }


3


}
