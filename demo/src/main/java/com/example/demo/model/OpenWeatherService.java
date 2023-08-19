package com.example.demo.model;
import com.example.demo.web.WeatherData;
public interface OpenWeatherService {
    WeatherData getWeatherByCity(String cityName);
}
