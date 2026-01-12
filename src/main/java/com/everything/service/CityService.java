package com.everything.service;


import com.everything.entity.City;
import com.everything.entity.Country;
import com.everything.repository.CityRepository;
import com.everything.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CityService {

    private final CityRepository cityRepository;
    private CountryRepository countryRepository;

    public CityService(CityRepository cityRepository, CountryRepository countryRepository) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
    }

    public City addCity(long countryId,City city) {
        Country country = countryRepository.findById(countryId).get();
        city.setCountry(country);
        City savedCity = cityRepository.save(city);
        return savedCity;
    }

    public List<City> getAllcity(City city) {
        List<City> allCity = cityRepository.findAll();
        return allCity;
    }
}

