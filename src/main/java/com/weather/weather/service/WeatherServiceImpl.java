package com.weather.weather.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.weather.client.WeatherFeignClient;
import com.weather.weather.constants.Constants;
import com.weather.weather.model.Location;
import com.weather.weather.model.Weather;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class WeatherServiceImpl implements WeatherService {
    @Autowired
    private final WeatherFeignClient weatherFeignClient;


    public Location getLocationInfo(String cityName) {
        return convertToLocationModel(weatherFeignClient.getLocationInfo(cityName, Constants.API_KEY));
    }

    @Override
    public Weather getCurrentWeather(String cityName) {
        getLocationInfo(cityName);
        return convertToWeatherModel(weatherFeignClient.getCurrentWeatherInfo(getLocationInfo(cityName).getId(), Constants.API_KEY));
    }

    @Override
    public Weather getDailyWeather(Long cityId) {
        return null;
    }

    public Location convertToLocationModel(ResponseEntity<String> response) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode node = objectMapper.readTree(response.getBody());
            return Location.builder().id(node.path("locations").get(0).get("id").asLong())
                    .cityName(node.path("locations").get(0).get("name").toString()).build();
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing JSON", e);
        }
    }

    public Weather convertToWeatherModel(ResponseEntity<String> response) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode node = objectMapper.readTree(response.getBody());
            return Weather.builder().pressure(node.path(Constants.CURRENT).get("pressure").toString()).time(LocalDate.now()).windSpeed(node.path(Constants.CURRENT).get("windSpeed").asInt())
                    .symbolPhrase(node.path(Constants.CURRENT).get("symbolPhrase").toString()).temperature(node.path(Constants.CURRENT).get("temperature").asInt())
                    .feelsLikeTemp(node.path(Constants.CURRENT).get("feelsLikeTemp").asInt()).build();
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing JSON", e);
        }
    }
}
