package rest.client.examples.location.list;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class ListLocationAsJSONString {

	public static void main(String[] args) {
		String requestURI = "http://localhost:8080/v1/locations";
		RestTemplate restTemplate = new RestTemplate();

		try {
			String response = restTemplate.getForObject(requestURI, String.class);
//			ResponseEntity<String> response = restTemplate.getForEntity(requestURI, String.class);
			System.out.println(response);
		} catch (RestClientResponseException e) {
			HttpStatusCode statusCode = e.getStatusCode();
			System.out.println("HTTP Status code: " + statusCode);
		}

	}

}
