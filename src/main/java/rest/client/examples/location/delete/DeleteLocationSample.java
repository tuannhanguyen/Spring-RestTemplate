package rest.client.examples.location.delete;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class DeleteLocationSample {

	public static void main(String[] args) {
		String requestURI = "http://localhost:8080/v1/locations/{code}";
		RestTemplate restTemplate = new RestTemplate();
		
		Map<String, String> params = new HashMap<>();
		params.put("code", "HN_VN");
		
		try {
			restTemplate.delete(requestURI, params);
			System.out.println("Location deleted");
		} catch (RestClientResponseException e) {
			System.out.println("Status code: " + e.getStatusCode());
			e.printStackTrace();
		}
	}

}
