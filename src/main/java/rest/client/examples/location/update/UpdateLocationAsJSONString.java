package rest.client.examples.location.update;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class UpdateLocationAsJSONString {

	public static void main(String[] args) {
		String requestURI = "http://localhost:8080/v1/locations";
		RestTemplate restTemplate = new RestTemplate();

		String json = "{\r\n"
				+ "    \"code\": \"NYC_USA\",\r\n"
				+ "    \"city_name\": \"New York\",\r\n"
				+ "    \"region_name\": \"DHMT1\",\r\n"
				+ "    \"country_name\": \"United States of America\",\r\n"
				+ "    \"country_code\": \"US\"\r\n"
				+ "}";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> request = new HttpEntity<String>(json, headers);

		try {
			restTemplate.put(requestURI, request);

			System.out.print("Location updated");
		} catch (RestClientResponseException e) {
			System.out.println("Error status code: " + e.getStatusCode());
			e.getStackTrace();
		}
	}
}
