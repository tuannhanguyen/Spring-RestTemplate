package rest.client.examples.realtimeweather.update;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import rest.client.examples.location.RealtimeWeather;

public class UpdateRealtimeWeatherAsObject {

	public static void main(String[] args) {
		String requestURI = "http://localhost:8080/v1/realtime/{code}";
		String locationCode = "NYC_USA";

		RealtimeWeather realtimeWeather = new RealtimeWeather();
		realtimeWeather.setTemperature(22);
		realtimeWeather.setHumidity(10);
		realtimeWeather.setPrecipation(27);
		realtimeWeather.setWindSpeed(17);
		realtimeWeather.setStatus("Sunny");

		RestTemplate restTemplate = new RestTemplate();

		Map<String, String> params = new HashMap<>();
		params.put("code", locationCode);

		HttpEntity<RealtimeWeather> request = new HttpEntity<RealtimeWeather>(realtimeWeather);

		ResponseEntity<RealtimeWeather> response = restTemplate.exchange(requestURI, HttpMethod.PUT, request, RealtimeWeather.class, params);

		if (response.getStatusCode().is2xxSuccessful()) {
		    System.out.println("Realtime Weather updated");
		    RealtimeWeather body = response.getBody();
		    System.out.println(body);
		}
	}
}
