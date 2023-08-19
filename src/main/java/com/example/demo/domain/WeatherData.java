package com.example.demo.domain;

import lombok.Data;
@Data
public class WeatherData {
    private String description;
    private Double temperature;
    private String cityName;
    private double humidity;
    public WeatherData() {
    }

    public WeatherData(String cityName, String description, Double temperature, double humidity) {
        this.cityName = cityName;
        this.description = description;
        this.temperature = temperature;
        this.humidity = humidity;
    }
}
