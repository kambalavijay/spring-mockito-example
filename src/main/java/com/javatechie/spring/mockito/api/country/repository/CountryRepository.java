package com.javatechie.spring.mockito.api.country.repository;

import com.javatechie.spring.mockito.api.country.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Optional<Country> findById(Long id);
}