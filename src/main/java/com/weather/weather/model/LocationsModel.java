package com.weather.weather.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class LocationsModel {
    private List<Locations> locations;

    @Data
    public static class Locations {
        private Long id;
        private String name;
        private String country;
        private String timezone;
        private String language;
        private String adminArea;
        private String adminArea2;
        private String adminArea3;
        private BigDecimal lon;
        private BigDecimal lat;
    }
}
