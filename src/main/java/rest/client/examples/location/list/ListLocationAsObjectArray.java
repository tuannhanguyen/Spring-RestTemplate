package rest.client.examples.location.list;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import rest.client.examples.location.Location;

public class ListLocationAsObjectArray {

	public static void main(String[] args) {
		String requestURI = "http://localhost:8080/v1/locations";
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			Location[] locations = restTemplate.getForObject(requestURI, Location[].class);
			
			if (locations != null && locations.length > 0) {
				for (Location location : locations) {
					System.out.println(location);
				}
			}
		} catch (HttpClientErrorException e) {
			HttpStatusCode statusCode = e.getStatusCode();
			System.out.println("HTTP Status code: " + statusCode);
		}

	}

}
