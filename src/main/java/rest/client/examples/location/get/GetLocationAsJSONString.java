package rest.client.examples.location.get;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GetLocationAsJSONString {

	public static void main(String[] args) {
		String requestURI = "http://localhost:8080/v1/locations/{code}";
		RestTemplate restTemplate = new RestTemplate();

		Map<String, String> params = new HashMap<>();
		params.put("code", "NYC_USA");

		ResponseEntity<String> response = restTemplate.getForEntity(requestURI, String.class, params);

		HttpStatusCode status = response.getStatusCode();

		if (status == HttpStatus.OK) {
			String body = response.getBody();
			System.out.println(body);
		}

	}

}
