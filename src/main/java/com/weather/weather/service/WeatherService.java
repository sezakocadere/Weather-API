package com.weather.weather.service;

import com.weather.weather.model.Location;
import com.weather.weather.model.Weather;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface WeatherService {

    Weather getCurrentWeather(String cityName);

    Weather getDailyWeather(Long cityId);
}
