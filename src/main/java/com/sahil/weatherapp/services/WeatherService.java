package com.sahil.weatherapp.services;

import com.sahil.weatherapp.models.ActivitiesRecommendation;
import com.sahil.weatherapp.models.Day;
import com.sahil.weatherapp.models.WeatherApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService
{

    @Value("${visualcrossing.api.key}")
    private String apiKey;
    private final RestClient restClient;

    public WeatherService(RestClient.Builder builder)
    {
        this.restClient = builder
                .baseUrl("https://weather.visualcrossing.com")
                .build();
    }

    public WeatherApiResponse getWeather(String location) {

        if (location == null || location.isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "City is required"
            );
        }

        try {
            WeatherApiResponse response = restClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/VisualCrossingWebServices/rest/services/timeline/{location}")
                            .queryParam("key", apiKey)
                            .queryParam("unitGroup", "us")
                            .queryParam("contentType", "json")
                            .build(location))
                    .retrieve()
                    .body(WeatherApiResponse.class);

            if (response == null) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_GATEWAY,
                        "Weather API returned no data"
                );
            }

            addRecommendations(response);
            return response;

        } catch (HttpClientErrorException.BadRequest e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Invalid city or location"
            );

        } catch (HttpClientErrorException.Unauthorized e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Weather API authentication failed"
            );

        } catch (RestClientException e) {
            throw new ResponseStatusException(
                    HttpStatus.SERVICE_UNAVAILABLE,
                    "Weather service is currently unavailable"
            );
        }
    }


    private void addRecommendations(WeatherApiResponse response) {

        if (response == null) {
            return;
        }

        List<ActivitiesRecommendation> recommendations = new ArrayList<>();

        if (response.getDays() == null || response.getDays().isEmpty()) {
            response.setActivitiesRecommendation(recommendations);
            return;
        }

        Day today = response.getDays().getFirst();

        String conditions = today.getConditions() == null
                ? ""
                : today.getConditions().toLowerCase();

        double temperature = today.getTemp();

        if (conditions.contains("rain")) {
            recommendations.add(new ActivitiesRecommendation(
                    "Indoor activity",
                    "Rain is expected today"
            ));
        } else if (conditions.contains("clear")
                && temperature >= 60
                && temperature <= 85) {

            recommendations.add(new ActivitiesRecommendation(
                    "Go for a walk",
                    "The weather is clear and comfortable"
            ));
        } else if (temperature > 85) {
            recommendations.add(new ActivitiesRecommendation(
                    "Swimming",
                    "The temperature is expected to be hot"
            ));
        } else if (temperature < 45) {
            recommendations.add(new ActivitiesRecommendation(
                    "Indoor workout",
                    "The temperature is expected to be cold"
            ));
        } else {
            recommendations.add(new ActivitiesRecommendation(
                    "Outdoor activity",
                    "The weather conditions are moderate"
            ));
        }

        response.setActivitiesRecommendation(recommendations);
    }

}
