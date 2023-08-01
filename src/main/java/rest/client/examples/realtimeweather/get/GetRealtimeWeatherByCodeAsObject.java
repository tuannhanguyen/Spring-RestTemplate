package rest.client.examples.realtimeweather.get;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import rest.client.examples.location.RealtimeWeather;

public class GetRealtimeWeatherByCodeAsObject {

    public static void main(String[] args) {
        String requestURI = "http://localhost:8080/v1/realtime/{code}";
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> params = new HashMap<>();
        params.put("code", "HP");

        try {
            ResponseEntity<RealtimeWeather> response = restTemplate.getForEntity(requestURI, RealtimeWeather.class, params);

            System.out.println(response.getBody());
        } catch (RestClientResponseException e) {
            System.out.println("Response error code: " + e.getStatusCode());
            e.printStackTrace();
        }

    }

}
