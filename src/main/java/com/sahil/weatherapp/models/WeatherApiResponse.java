package com.sahil.weatherapp.models;

import java.util.List;

public class WeatherApiResponse
{
    private String location;
    private String currentConditions;
    private List<Day> days;
    private List<Alert> alerts;
    private List<ActivitiesRecommendation> activitiesRecommendation;
}
