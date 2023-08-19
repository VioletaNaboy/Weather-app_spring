package com.example.demo.repository;
import com.example.demo.domain.WeatherData;
import org.springframework.stereotype.Repository;

@Repository
public interface OpenWeatherRepository {
    WeatherData getWeatherByCity(String cityName);
}
