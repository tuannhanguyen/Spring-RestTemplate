package rest.client.examples.realtimeweather.get;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import rest.client.examples.location.RealtimeWeather;

public class GetRealtimeWeatherByIPAsObject {

    public static void main(String[] args) {
        String requestURI = "http://localhost:8080/v1/realtime";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String clientIPAddress = "14.228.103.80";
        headers.set("X-FORWARDED-FOR", clientIPAddress);

        HttpEntity<?> request = new HttpEntity<>(headers);

        ResponseEntity<RealtimeWeather> response = restTemplate.exchange(requestURI, HttpMethod.GET, request, RealtimeWeather.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            RealtimeWeather body = response.getBody();
            System.out.println(body);
        }
    }

}
