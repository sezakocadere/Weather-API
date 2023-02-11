package com.weather.weather.model;

import lombok.Data;

@Data
public class Location {
    private Long id;
    private String cityName;
    private String countryName;
}