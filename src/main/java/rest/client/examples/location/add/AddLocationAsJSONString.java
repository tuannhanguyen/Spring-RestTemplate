package rest.client.examples.location.add;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AddLocationAsJSONString {

	public static void main(String[] args) {

		String requestURI = "http://localhost:8080/v1/locations";
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		String json = "{\r\n"
				+ "    \"code\": \"MADRID_ES\",\r\n"
				+ "    \"city_name\": \"Madrid\",\r\n"
				+ "    \"region_name\": \"DHMT\",\r\n"
				+ "    \"country_name\": \"Spain\",\r\n"
				+ "    \"country_code\": \"ES\"\r\n"
				+ "}";
		HttpEntity<String> request = new HttpEntity<String>(json, headers);
		ResponseEntity<String> response = restTemplate.postForEntity(requestURI, request, String.class);

		HttpStatusCode statusCode = response.getStatusCode();
		String responseBody = response.getBody();
		System.out.println(responseBody);
		System.out.println(statusCode);
	}

}
