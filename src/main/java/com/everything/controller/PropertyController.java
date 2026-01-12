package com.everything.controller;


import com.everything.entity.Property;
import com.everything.service.PropertyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/property")
public class PropertyController {

    private PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping("/addProperty")
    public ResponseEntity<Property> addProperty(@RequestParam long cityId, @RequestBody Property property){
        Property savedProperty = propertyService.addProperty(cityId,property);
        return new ResponseEntity<>(savedProperty, HttpStatus.CREATED);
    }

    @GetMapping("/allProperty")
    public ResponseEntity<List<Property>>getAllProperty(Property property){
        List<Property> allProperty = propertyService.getAllProperty(property);
        return new ResponseEntity<>(allProperty,HttpStatus.OK);
    }

    @GetMapping("/searchHotels")
    public ResponseEntity<Property>searchHotelByName(@RequestParam String name){
        Property property = propertyService.searchHotel(name);
        return new ResponseEntity<>(property,HttpStatus.OK);
    }
}
