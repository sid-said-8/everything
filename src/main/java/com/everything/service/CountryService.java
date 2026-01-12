package com.everything.service;


import com.everything.entity.Country;
import com.everything.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Country addCountry(Country country) {
        Country savedCountry = countryRepository.save(country);
        return savedCountry;
    }

    public List<Country> getAllCountry(Country country) {
        List<Country> allCountry = countryRepository.findAll();
        return allCountry;
    }
}
