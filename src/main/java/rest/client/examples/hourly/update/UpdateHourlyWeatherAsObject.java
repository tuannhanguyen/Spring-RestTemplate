package rest.client.examples.hourly.update;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import rest.client.examples.location.HourlyWeather;

public class UpdateHourlyWeatherAsObject {

    public static void main(String[] args) {
        String requestURI = "http://localhost:8080/v1/hourly/{code}";
        String locationCode = "HCM_VN";

        RestTemplate restTemplate = new RestTemplate();

        HourlyWeather forecats1 = new HourlyWeather();
        forecats1.setHourOfDay("10");
        forecats1.setTemperature(20);
        forecats1.setPrecipitation(13);
        forecats1.setStatus("Sunny");

        HourlyWeather forecast2 = new HourlyWeather();
        forecast2.setHourOfDay("12");
        forecast2.setTemperature(12);
        forecast2.setPrecipitation(11);
        forecast2.setStatus("Cloudly");

        HourlyWeather forecast3 = new HourlyWeather();
        forecast3.setHourOfDay("14");
        forecast3.setTemperature(15);
        forecast3.setPrecipitation(15);
        forecast3.setStatus("Clear");

        HourlyWeather[] hourlyForecast = new HourlyWeather[] { forecats1, forecast2, forecast3 };

        HttpEntity<?> request = new HttpEntity<Object>(hourlyForecast);

        ResponseEntity<?> response = restTemplate.exchange(requestURI, HttpMethod.PUT, request, Object.class,
                locationCode);

        HttpStatusCode statusCode = response.getStatusCode();
        System.out.println("Status code: " + statusCode);

        if (statusCode.value() == HttpStatus.OK.value()) {
            System.out.println("Hourly weather data updated");
            System.out.println(response.getBody());
        }
    }
}
