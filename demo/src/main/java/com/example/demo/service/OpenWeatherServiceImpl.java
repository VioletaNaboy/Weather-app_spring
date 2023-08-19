package com.example.demo.service;
import com.example.demo.web.WeatherData;
import com.example.demo.model.OpenWeatherService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class OpenWeatherServiceImpl implements OpenWeatherService{
    @Value("${openweather.api.key}")
    private String apiKey;
    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseUrl = "http://api.openweathermap.org/data/2.5/weather";

    @Override
    public WeatherData getWeatherByCity(String cityName) {
        String apiUrl = baseUrl + "?q=" + cityName + "&appid=" + apiKey + "&units=metric";
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            String json = response.getBody();
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode rootNode = objectMapper.readTree(json);

                double temperature = rootNode.get("main").get("temp").asDouble();
                int humidity = rootNode.get("main").get("humidity").asInt();
                String nameCity = rootNode.get("name").asText();
                String mainDescription = rootNode.get("weather").get(0).get("main").asText();
                return new WeatherData(cityName, mainDescription, temperature, humidity);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
