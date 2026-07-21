package com.sahil.weatherapp.controllers;

import com.sahil.weatherapp.models.WeatherApiResponse;
import com.sahil.weatherapp.services.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController
{
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService)
    {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public WeatherApiResponse getWeather(@RequestParam String city)
    {
        return weatherService.getWeather(city);
    }
}
