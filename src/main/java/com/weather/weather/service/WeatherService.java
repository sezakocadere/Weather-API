package com.weather.weather.service;

import com.weather.weather.model.Location;
import com.weather.weather.model.Weather;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WeatherService {

    Weather getCurrentWeather(String cityName);

    List<Weather> getWeeklyWeather(String cityName);
}
