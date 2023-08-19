package com.example.demo.service;
import com.example.demo.repository.Impls.OpenWeatherRepositoryImpl;
import com.example.demo.domain.WeatherData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class WeatherService {
    private OpenWeatherRepositoryImpl openWeatherRepositoryImpl;


    public WeatherData getWeatherByCity(String cityName) {
        return openWeatherRepositoryImpl.getWeatherByCity(cityName);
    }
}
