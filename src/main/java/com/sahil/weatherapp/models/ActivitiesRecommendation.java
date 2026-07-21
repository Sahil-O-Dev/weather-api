package com.sahil.weatherapp.models;

public class ActivitiesRecommendation
{
    private String activity;
    private String reason;

    public ActivitiesRecommendation(String activity, String reason)
    {
        this.activity = activity;
        this.reason = reason;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "ActivitiesRecommendation{" +
                "activity='" + activity + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
