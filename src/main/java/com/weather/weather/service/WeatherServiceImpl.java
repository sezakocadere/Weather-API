package com.weather.weather.service;

import com.weather.weather.client.WeatherFeignClient;
import com.weather.weather.constants.Constants;
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
        LocationsModel locationInfo = weatherFeignClient.getLocationInfo(cityName, Constants.API_KEY);
        return locationInfo.getLocations().get(0);
    }

    @Override
    public Weather getCurrentWeather(String cityName) {
        CurrentModel.Current currentWeather = weatherFeignClient.getCurrentWeatherInfo(getLocationInfo(cityName).getId(), Constants.API_KEY).getCurrent();
        Weather weather = new Weather();
        weather.setTime(currentWeather.getTime());
        weather.setPressure(currentWeather.getPressure());
        weather.setTemperature(currentWeather.getTemperature());
        weather.setWindSpeed(currentWeather.getWindSpeed());
        weather.setSymbolPhrase(currentWeather.getSymbolPhrase());
        weather.setFeelsLikeTemp(currentWeather.getFeelsLikeTemp());
        return weather;
    }

    @Override
    public List<Weather> getWeeklyWeather(String cityName) {
        List<Weather> weathers = new ArrayList<>();
        List<WeeklyModel.Forecast> weeklyWeathers = weatherFeignClient.getWeeklyWeatherInfo(getLocationInfo(cityName).getId(), Constants.API_KEY).getForecast();
        for (WeeklyModel.Forecast weeklyWeather : weeklyWeathers) {
            Weather weather = new Weather();
            weather.setTime(weeklyWeather.getDate());
            weather.setTemperature(weeklyWeather.getMaxTemp());
            weather.setWindSpeed(weeklyWeather.getMaxWindSpeed());
            weathers.add(weather);
        }
        return weathers;
    }
}
