package rest.client.examples.location.update;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import rest.client.examples.location.Location;

public class UpdateLocationAsObject {

	public static void main(String[] args) {
		String requestURI = "http://localhost:8080/v1/locations";
		RestTemplate restTemplate = new RestTemplate();
		
		String json = "{\r\n"
				+ "    \"code\": \"NYC_USA\",\r\n"
				+ "    \"city_name\": \"New York1\",\r\n"
				+ "    \"region_name\": \"DHMT11\",\r\n"
				+ "    \"country_name\": \"United States of America11\",\r\n"
				+ "    \"country_code\": \"US\"\r\n"
				+ "}";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> request = new HttpEntity<String>(json, headers);
		
		ResponseEntity<Location> response = restTemplate.exchange(requestURI, HttpMethod.PUT, request, Location.class);
		
		if (response.getStatusCode().is2xxSuccessful()) {
			Location updatedLocation = response.getBody();
			System.out.print(updatedLocation);
		}
	}
}
