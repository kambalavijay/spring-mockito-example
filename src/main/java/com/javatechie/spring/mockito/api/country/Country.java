package com.javatechie.spring.mockito.api.country;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "country")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name", nullable = false)
    String name;
    @Column(name = "code", nullable = false)
    String code;
    @Column(name = "population", nullable = false)
    Long population;
    @Column(name = "capital", nullable = false)
    String capital;
    @Column(name = "continent", nullable = false)
    String continent;
}
