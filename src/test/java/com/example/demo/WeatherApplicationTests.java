package com.example.demo;
import com.example.demo.domain.WeatherData;
import com.example.demo.service.WeatherService;
import com.example.demo.repository.Impls.OpenWeatherRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@SpringBootTest
class WeatherApplicationTests {
	@Test
	void contextLoads() {
	}

}
class WeatherServiceTest {

	@InjectMocks
	private WeatherService weatherService;

	@Mock
	private OpenWeatherRepositoryImpl openWeatherRepositoryImpl;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetWeatherByCity() {
		String cityName = "New York";
		WeatherData weatherData = new WeatherData(cityName, "Sunny", 25.0, 60.0);
		when(openWeatherRepositoryImpl.getWeatherByCity(cityName)).thenReturn(weatherData);

		WeatherData result = weatherService.getWeatherByCity(cityName);

		assertEquals(weatherData, result);
		verify(openWeatherRepositoryImpl, times(1)).getWeatherByCity(cityName);
	}
}
