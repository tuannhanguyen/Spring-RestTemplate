package rest.client.examples.hourly.get;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import rest.client.examples.location.HourlyForecastDTO;

public class GetHourlyWeatherByIPAsObject {

    public static void main(String[] args) {
        String requestURI = "http://localhost:8080/v1/hourly";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-FORWARDED-FOR", "216.165.36.131");
        headers.add("X-Current-Hour", "8");

        HttpEntity<?> request = new HttpEntity<>(headers);

        ResponseEntity<HourlyForecastDTO> response = restTemplate.exchange(requestURI, HttpMethod.GET, request, HourlyForecastDTO.class);

        HttpStatusCode statusCode = response.getStatusCode();

        System.out.println("Status code: " + statusCode);

        if (statusCode.value() == HttpStatus.NO_CONTENT.value()) {
            System.out.println("No hourly forecast data available");
        } else if (statusCode.value() == HttpStatus.OK.value()) {
            HourlyForecastDTO dto = response.getBody();
            System.out.println("Location: " + dto.getLocation());

            dto.getHourlyForecastDTOs().forEach(System.out::println);
        }
    }

}
