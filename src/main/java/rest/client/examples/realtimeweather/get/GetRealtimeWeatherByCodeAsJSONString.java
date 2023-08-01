package rest.client.examples.realtimeweather.get;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

public class GetRealtimeWeatherByCodeAsJSONString {

    public static void main(String[] args) {
        String requestURI = "http://localhost:8080/v1/realtime/{code}";
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> params = new HashMap<>();
        params.put("code", "HP");

        String response = restTemplate.getForObject(requestURI, String.class, params);

        System.out.println(response);

    }

}
