package rest.client.examples.hourly.get;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GetHourlyWeatherByCodeAsJSONString {

    public static void main(String[] args) {
        String requestURI = "http://localhost:8080/v1/hourly/{code}";
        String locationCode = "HCM_VN";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Current-Hour", "11");

        HttpEntity<?> request = new HttpEntity<String>(headers);

        ResponseEntity<String> response = restTemplate.exchange(requestURI, HttpMethod.GET, request, String.class, locationCode);

        HttpStatusCode statusCode = response.getStatusCode();

        System.out.println("Status code: " + statusCode);

        if (statusCode.value() == HttpStatus.NO_CONTENT.value()) {
            System.out.println("No hourly forecast data available");
        } else if (statusCode.value() == HttpStatus.BAD_REQUEST.value()) {
            System.out.println("Invalid value of request header: X-Current-Hour");
        } else if (statusCode.value() == HttpStatus.NOT_FOUND.value()) {
            System.out.println("No managed location found for the given location code");
        } else if (statusCode.value() == HttpStatus.OK.value()) {
            String body = response.getBody();
            System.out.println(body);
        }
    }
}
