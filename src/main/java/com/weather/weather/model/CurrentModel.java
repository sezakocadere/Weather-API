package com.weather.weather.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CurrentModel {
    private Current current;

    @Data
    public static class Current {
        private String time;
        private String symbol;
        private String symbolPhrase;
        private int temperature;
        private int feelsLikeTemp;
        private int relHumidity;
        private int dewPoint;
        private int windSpeed;
        private int windDir;
        private String windDirString;
        private int windGust;
        private int precipProb;
        private int precipRate;
        private int cloudiness;
        private int thunderProb;
        private int uvIndex;
        private BigDecimal pressure;
        private int visibility;
    }
}

