package com.sahil.weatherapp.models;

public class Alert
{
    private String event;
    private String headline;
    private String description;


    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "event='" + event + '\'' +
                ", headline='" + headline + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
