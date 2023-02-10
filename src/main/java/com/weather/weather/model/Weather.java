package com.weather.weather.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Weather {
    private BigDecimal pressure;
    private String time;
    private Integer windSpeed;
    private String symbolPhrase;
    private Integer temperature;
    private Integer feelsLikeTemp;
}
