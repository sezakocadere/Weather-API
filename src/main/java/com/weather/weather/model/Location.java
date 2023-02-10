package com.weather.weather.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Location {
    private Long id;
    private String cityName;
    private String countryName;
    private BigDecimal lon;
    private BigDecimal lat;
}
