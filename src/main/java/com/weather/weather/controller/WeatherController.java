package com.weather.weather.controller;

import com.weather.weather.model.Weather;
import com.weather.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("weather")
@RequiredArgsConstructor
public class WeatherController {
    // @Autowired
    private final WeatherService weatherService;

    @GetMapping(value = "/{cityName}")
    public Weather getWeather(@PathVariable String cityName) {
        return weatherService.getCurrentWeather(cityName);
    }
}
