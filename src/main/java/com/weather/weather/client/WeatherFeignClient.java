package com.weather.weather.client;

import com.weather.weather.constants.Constants;
import com.weather.weather.model.CurrentModel;
import com.weather.weather.model.LocationsModel;
import com.weather.weather.model.WeeklyModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "foreca-service", url = Constants.WEATHER_API_URL)
public interface WeatherFeignClient {
    @GetMapping("/location/search/{cityName}")
    LocationsModel getLocationInfo(@PathVariable String cityName, @RequestHeader("Authorization") String bearer);

    // example request:https://pfa.foreca.com/api/v1/location/search/istanbul
    @GetMapping("/current/{cityId}")
    CurrentModel getCurrentWeatherInfo(@PathVariable Long cityId, @RequestHeader("Authorization") String bearer);
    // example request:https://pfa.foreca.com/api/v1/current/100745044

    @GetMapping("/forecast/daily/{cityId}")
    WeeklyModel getWeeklyWeatherInfo(@PathVariable Long cityId, @RequestHeader("Authorization") String bearer);
    // example request:https://pfa.foreca.com/api/v1/forecast/daily/100184745
}