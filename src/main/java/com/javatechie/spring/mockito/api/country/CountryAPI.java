package com.javatechie.spring.mockito.api.country;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CountryAPI {

    private MessageSource messageSource;
    private CountryService countryService;
    private Logger logger = LoggerFactory.getLogger(CountryAPI.class);

    @Autowired
    public CountryAPI(MessageSource messageSource, CountryService countryService) {
        this.messageSource = messageSource;
        this.countryService = countryService;
    }

    @GetMapping("/country/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable Long id){
        Country country = countryService.getCountryById(id);
        if (country == null){
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok(country);
        }
    }

    @PostMapping("/country")
    public ResponseEntity<Country> createCountry(@RequestBody CountryVO countryVO){
        Country country = countryService.createCountry(countryVO);
        return ResponseEntity.ok(country);
    }
}
