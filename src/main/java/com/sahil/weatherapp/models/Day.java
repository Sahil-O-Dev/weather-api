package com.sahil.weatherapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Day
{
    private String datetime;
    private List<Hour> hours;
    @JsonProperty("tempmax")
    private double tempMax;
    @JsonProperty("tempmin")
    private double tempMin;
    private double temp;
    private String icon;
    private String conditions;


    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public List<Hour> getHours() {
        return hours;
    }

    public void setHours(List<Hour> hours) {
        this.hours = hours;
    }

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    @Override
    public String toString() {
        return "Day{" +
                "datetime='" + datetime + '\'' +
                ", hours=" + hours +
                ", tempMax=" + tempMax +
                ", tempMin=" + tempMin +
                ", temp=" + temp +
                ", icon='" + icon + '\'' +
                ", conditions='" + conditions + '\'' +
                '}';
    }
}