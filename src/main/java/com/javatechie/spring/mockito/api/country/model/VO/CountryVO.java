package com.javatechie.spring.mockito.api.country.model.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountryVO {
    String name;
    String code;
    Long population;
    String capital;
    String continent;
}
