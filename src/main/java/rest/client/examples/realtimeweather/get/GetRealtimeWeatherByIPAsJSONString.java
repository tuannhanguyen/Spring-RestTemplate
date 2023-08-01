package rest.client.examples.realtimeweather.get;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class GetRealtimeWeatherByIPAsJSONString {

    public static void main(String[] args) {
        String requestURI = "http://localhost:8080/v1/realtime";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String clientIPAddress = "14.228.103.80";
        headers.set("X-FORWARDED-FOR", clientIPAddress);

        HttpEntity<String> request = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(requestURI, HttpMethod.GET, request, String.class);

            System.out.println(response.getBody());
        } catch (HttpClientErrorException e) {
            System.out.println("Error code: " + e.getStatusCode());
            e.printStackTrace();
        }




    }

}
