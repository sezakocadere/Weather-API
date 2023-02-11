package com.weather.weather.service;

import com.weather.weather.model.Weather;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WeatherService {

    Weather getCurrentWeather(String cityName);
    // returns current weather estimate

    List<Weather> getWeeklyWeather(String cityName);
    // return daily forecasts, up to 7 days
}