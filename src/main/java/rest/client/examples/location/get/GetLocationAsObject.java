package rest.client.examples.location.get;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import rest.client.examples.location.Location;

public class GetLocationAsObject {

	public static void main(String[] args) {
		String requestURI = "http://localhost:8080/v1/locations/NYC_USA";
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Location> response = restTemplate.getForEntity(requestURI, Location.class);
		HttpStatusCode statusCode = response.getStatusCode();

		if (statusCode == HttpStatus.OK) {
			Location location = response.getBody();
			System.out.println(location);
		}

	}

}
