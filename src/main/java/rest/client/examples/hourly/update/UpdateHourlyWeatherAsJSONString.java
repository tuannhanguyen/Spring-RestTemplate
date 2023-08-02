package rest.client.examples.hourly.update;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class UpdateHourlyWeatherAsJSONString {

    public static void main(String[] args) {
        String requestURI = "http://localhost:8080/v1/hourly/{code}";
        String locationCode = "HCM_VN";

        RestTemplate restTemplate = new RestTemplate();

        String json = "[\r\n"
                + "    {\r\n"
                + "        \"hour_of_day\": 10,\r\n"
                + "        \"temperature\": 21,\r\n"
                + "        \"precipitation\": 12,\r\n"
                + "        \"status\": \"Rainy\"\r\n"
                + "    },\r\n"
                + "    {\r\n"
                + "        \"hour_of_day\": 12,\r\n"
                + "        \"temperature\": 21,\r\n"
                + "        \"precipitation\": 33,\r\n"
                + "        \"status\": \"Rainy\"\r\n"
                + "    },\r\n"
                + "    {\r\n"
                + "        \"hour_of_day\": 15,\r\n"
                + "        \"temperature\": 20,\r\n"
                + "        \"precipitation\": 29,\r\n"
                + "        \"status\": \"Sunny\"\r\n"
                + "    }\r\n"
                + "]";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<String>(json, headers);

        try {
            restTemplate.put(requestURI, request, locationCode);

            System.out.println("Hourly weather data updated");
        } catch (RestClientResponseException e) {
            System.out.println("Error status code: " + e.getStatusCode());
            e.printStackTrace();
        }
    }
}
