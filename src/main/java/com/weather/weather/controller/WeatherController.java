package com.weather.weather.controller;

import com.weather.weather.model.Weather;
import com.weather.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("weather")
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping(value = "/current/{cityName}")
    public Weather getCurrentWeather(@PathVariable String cityName) {
        return weatherService.getCurrentWeather(cityName);
    }

    @GetMapping(value = "/weekly/{cityName}")
    public List<Weather> getWeeklyWeather(@PathVariable String cityName) {
        return weatherService.getWeeklyWeather(cityName);
    }
}