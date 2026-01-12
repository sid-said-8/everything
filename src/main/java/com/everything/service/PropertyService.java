package com.everything.service;


import com.everything.entity.City;
import com.everything.entity.Property;
import com.everything.entity.Country;
import com.everything.repository.CityRepository;
import com.everything.repository.PropertyRepository;
import com.everything.repository.PropertyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    private PropertyRepository propertyRepository;
    private CityRepository cityRepository;

    public PropertyService(PropertyRepository propertyRepository, CityRepository cityRepository) {
        this.propertyRepository = propertyRepository;
        this.cityRepository = cityRepository;
    }

    public Property addProperty(long cityId, Property property) {
        City city = cityRepository.findById(cityId).get();
        property.setCity(city);
        Property savedProperty = propertyRepository.save(property);
        return savedProperty;
    }

    public List<Property> getAllProperty(Property property) {
        List<Property> allProperty = propertyRepository.findAll();
        return allProperty;
    }

    public Property searchHotel(String name) {
        Property property = propertyRepository.findByName(name).get();
        return property;
    }
}
