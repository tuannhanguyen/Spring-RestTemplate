package rest.client.examples.realtimeweather.update;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class UpdateRealtimeWeatherAsObject {

	public static void main(String[] args) {
		String requestURI = "http://localhost:8080/v1/realtime/{code}";
		String locationCode = "BK_TL";
		
		RestTemplate restTemplate = new RestTemplate();
		
		Map<String, String> params = new HashMap<>();
		params.put("code", locationCode);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		String json = "";
		
		HttpEntity<String> request = new HttpEntity<String>(json, headers);
		restTemplate.put(requestURI, request, params);
		
		
		
		
		

	}

}
