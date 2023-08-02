package rest.client.examples.realtimeweather.update;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class UpdateRealtimeWeatherAsJSONString {

    public static void main(String[] args) {
        String requestURI = "http://localhost:8080/v1/realtime/{code}";
        String locationCode = "HCM_VN";

        RestTemplate restTemplate = new RestTemplate();

        String json = "{\r\n"
                + "    \"temperature\": 11,\r\n"
                + "    \"humidity\": 11,\r\n"
                + "    \"precipation\": 21,\r\n"
                + "    \"status\": \"Sunny\",\r\n"
                + "    \"wind_speed\": 8\r\n"
                + "}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<String>(json, headers);

        Map<String, String> params = new HashMap<>();
        params.put("code", locationCode);

        try {
            restTemplate.put(requestURI, request, params);
            System.out.println("Realtime weather updated");
        } catch (RestClientResponseException e) {
            System.out.println("Error status code: " + e.getStatusCode());
            e.printStackTrace();
        }
    }

}
