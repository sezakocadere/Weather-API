package com.weather.weather.model;

import lombok.Data;

import java.util.List;

@Data
public class WeeklyModel {
    private List<Forecast> forecast;

    @Data
    public static class Forecast {
        private String date;
        private String symbol;
        private Integer maxTemp;
        private Integer minTemp;
        private Integer precipAccum;
        private Integer maxWindSpeed;
        private Integer windDir;
    }
}
