package com.example.demo.controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.model.OpenWeatherService;
import com.example.demo.web.WeatherData;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class WeatherController {
    private final OpenWeatherService openWeatherService;

    public WeatherController(OpenWeatherService openWeatherService) {
        this.openWeatherService = openWeatherService;
    }

    @GetMapping("/weather/{cityName}")
    public WeatherData getWeather(@PathVariable String cityName) {
        return openWeatherService.getWeatherByCity(cityName);
    }
}
