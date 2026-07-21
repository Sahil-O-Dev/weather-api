package com.sahil.weatherapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherApiResponse
{
    private String resolvedAddress;
    private List<Day> days;
    private List<Alert> alerts;
    private List<ActivitiesRecommendation> activitiesRecommendation;



    public String getResolvedAddress() {
        return resolvedAddress;
    }

    public void setResolvedAddress(String resolvedAddress) {
        this.resolvedAddress = resolvedAddress;
    }

    public List<Alert> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<Alert> alerts) {
        this.alerts = alerts;
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }

    public List<ActivitiesRecommendation> getActivitiesRecommendation() {
        return activitiesRecommendation;
    }

    public void setActivitiesRecommendation(List<ActivitiesRecommendation> activitiesRecommendation) {
        this.activitiesRecommendation = activitiesRecommendation;
    }
}
