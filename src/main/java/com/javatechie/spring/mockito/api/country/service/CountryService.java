package com.javatechie.spring.mockito.api.country.service;

import com.javatechie.spring.mockito.api.country.model.Country;
import com.javatechie.spring.mockito.api.country.model.VO.CountryVO;
import com.javatechie.spring.mockito.api.country.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    @Autowired
    CountryRepository countryRepository;

    public Country getCountryById(Long id){
        return countryRepository.findById(id).orElse(null);
    }

    public Country createCountry(CountryVO countryVO){
        Country country = Country.builder().capital(countryVO.getCapital()).
                code(countryVO.getCode()).
                name(countryVO.getName()).population(countryVO.getPopulation()).continent(countryVO.getContinent()).build();
        return countryRepository.save(country);
    }
}
