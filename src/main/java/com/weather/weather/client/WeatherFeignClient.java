package com.weather.weather.client;

import com.weather.weather.constants.Constants;
import com.weather.weather.model.Location;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.validation.Valid;

@Validated
@FeignClient(value = "foreca-service", url = Constants.WEATHER_API_URL)
public interface WeatherFeignClient {

    //    @FeignClient(value = "foreca-service", url = Constants.WEATHER_API_URL)

    //    @Headers(Constants.API_KEY)
    //    @GetMapping("/location/search/{cityName}")
    @GetMapping("/location/search/{cityName}")
    ResponseEntity<String> getLocationInfo(@PathVariable String cityName, @RequestHeader("Authorization") String bearer);

    //https://pfa.foreca.com/api/v1/location/search/istanbul
       @Valid
    @GetMapping("/current/{cityId}")
    ResponseEntity<String> getCurrentWeatherInfo(@PathVariable Long cityId, @RequestHeader("Authorization") String bearer);
    //@RequestParam
    //https://pfa.foreca.com/api/v1/current/100745044
}