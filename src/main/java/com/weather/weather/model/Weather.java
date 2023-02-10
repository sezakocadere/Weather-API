package com.weather.weather.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Weather {
    private String pressure;
    private LocalDate time;
    private int windSpeed;
    private String symbolPhrase;
    private int temperature;
    private int feelsLikeTemp;
 //   private Location location;
}
