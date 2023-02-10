package com.weather.weather.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Location {
    private Long id;
    private String cityName;
    private String countryName;
}
