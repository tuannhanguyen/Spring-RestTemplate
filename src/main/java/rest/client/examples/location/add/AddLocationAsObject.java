package rest.client.examples.location.add;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import rest.client.examples.location.Location;

public class AddLocationAsObject {

	public static void main(String[] args) {

		String requestURI = "http://localhost:8080/v1/locations";
		RestTemplate restTemplate = new RestTemplate();

		Location newLocation = new Location();
		newLocation.setCode("BK_TL");
		newLocation.setCityName("BangKok");
		newLocation.setRegionName("DHMT");
		newLocation.setCountryName("Thailand");
		newLocation.setCountryCode("TL");

		HttpEntity<Location> request = new HttpEntity<Location>(newLocation);
		ResponseEntity<Location> response = restTemplate.postForEntity(requestURI, request, Location.class);

		HttpStatusCode statusCode = response.getStatusCode();
		Location responseBody = response.getBody();
		System.out.println(responseBody);
		System.out.println(statusCode);
	}

}
