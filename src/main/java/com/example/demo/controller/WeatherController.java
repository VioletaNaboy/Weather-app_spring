package com.example.demo.controller;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.service.WeatherService;
import com.example.demo.domain.WeatherData;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
@AllArgsConstructor
public class WeatherController {
    WeatherService weatherService;


    @GetMapping("/weather/{cityName}")
    public WeatherData getWeather(@PathVariable String cityName) {
        return weatherService.getWeatherByCity(cityName);
    }
}
