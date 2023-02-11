package com.weather.weather.service;

import com.weather.weather.client.WeatherFeignClient;
import com.weather.weather.constants.Constants;
import com.weather.weather.exception.NotFoundCity;
import com.weather.weather.model.CurrentModel;
import com.weather.weather.model.LocationsModel;
import com.weather.weather.model.Weather;
import com.weather.weather.model.WeeklyModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class WeatherServiceImpl implements WeatherService {
    private final WeatherFeignClient weatherFeignClient;

    public LocationsModel.Locations getLocationInfo(String cityName) {
        // foreca.com makes current/weekly weather forecasts based on location id, so need to find the location id with given city name
        LocationsModel locationInfo = weatherFeignClient.getLocationInfo(cityName, Constants.API_KEY);
        if (locationInfo.getLocations().isEmpty()) {
            throw new NotFoundCity("City/Country Not Found");
        }
        return locationInfo.getLocations().get(0);
    }

    @Override
    public Weather getCurrentWeather(String cityName) {
        LocationsModel.Locations locationInfo = getLocationInfo(cityName);
        CurrentModel.Current currentWeather = weatherFeignClient.getCurrentWeatherInfo(locationInfo.getId(), Constants.API_KEY).getCurrent();
        Weather weather = new Weather();
        weather.setTime(currentWeather.getTime());
        weather.setPressure(currentWeather.getPressure());
        weather.setTemperature(currentWeather.getTemperature());
        weather.setWindSpeed(currentWeather.getWindSpeed());
        weather.setSymbolPhrase(currentWeather.getSymbolPhrase());
        weather.setFeelsLikeTemp(currentWeather.getFeelsLikeTemp());
        weather.setLocationName(locationInfo.getName());  // if missing location name is entered, locations list of contains this missing letter, and it is chosen so locationName set to it, not set entered missing location name
        return weather;
    }

    @Override
    public List<Weather> getWeeklyWeather(String cityName) {
        List<Weather> weathers = new ArrayList<>();
        LocationsModel.Locations locationInfo = getLocationInfo(cityName); // It is introduced in the variable so that it does not call the method twice and send multiple request
        List<WeeklyModel.Forecast> weeklyWeathers = weatherFeignClient.getWeeklyWeatherInfo(locationInfo.getId(), Constants.API_KEY).getForecast();
        for (WeeklyModel.Forecast weeklyWeather : weeklyWeathers) {
            Weather weather = new Weather();
            weather.setTime(weeklyWeather.getDate());
            weather.setTemperature(weeklyWeather.getMaxTemp());
            weather.setWindSpeed(weeklyWeather.getMaxWindSpeed());
            weather.setLocationName(locationInfo.getName());
            weathers.add(weather);
        }
        return weathers;
    }
}