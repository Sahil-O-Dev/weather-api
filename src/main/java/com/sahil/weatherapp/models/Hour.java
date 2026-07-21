package com.sahil.weatherapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Hour {

    private String datetime;
    private double temp;
    private double humidity;
    private double dew;
    @JsonProperty("windspeed")
    private double windSpeed;
    private double pressure;
    @JsonProperty("cloudcover")
    private double cloudCover;
    private String conditions;
    private String icon;
    @JsonProperty("feelslike")
    private double feelsLike;


    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public double getDew() {
        return dew;
    }

    public void setDew(double dew) {
        this.dew = dew;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public double getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(double cloudCover) {
        this.cloudCover = cloudCover;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Hour{" +
                "datetime='" + datetime + '\'' +
                ", temp=" + temp +
                ", humidity=" + humidity +
                ", dew=" + dew +
                ", windSpeed=" + windSpeed +
                ", pressure=" + pressure +
                ", cloudCover=" + cloudCover +
                ", conditions='" + conditions + '\'' +
                ", icon='" + icon + '\'' +
                ", feelsLike=" + feelsLike +
                '}';
    }
}
