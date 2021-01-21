package com.Unific.SoftwareEngTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class SoftwareEngTestApplicationTests {

	private RestTemplate restTemplate;

	@LocalServerPort
	private String serverPort;

	@BeforeEach
	public void setup(){
		restTemplate = new RestTemplate();
	}

	@Test
	void testGetTwoCharacters() {

		final String baseUrl = "http://localhost:" + serverPort + "/get2Characters/?gender={gender}&status={status}";
		HashMap<String, String> params = new HashMap<>();
		params.put( "gender", "male" );
		params.put( "status", "alive" );

		ResponseEntity<List> result = restTemplate.getForEntity( baseUrl, List.class , params);

		//Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
		List<LinkedHashMap<String,String>> results = result.getBody();
		assertEquals( results.size() , 2 );
		assertEquals( results.get( 0 ).get( "gender" ) , "Male");
		assertEquals( results.get( 0 ).get( "status" ) , "Alive");

	}

	@Test
	void testGetLocations() {

		final String baseUrl = "http://localhost:" + serverPort + "/getLocations/?type={type}";
		HashMap<String, String> params = new HashMap<>();
		params.put( "type", "planet" );

		ResponseEntity<List> result = restTemplate.getForEntity( baseUrl, List.class, params);

		//Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
		List<LinkedHashMap<String,String>> results = result.getBody();
		assertEquals( results.size() , 20 );

		results.forEach( location -> assertEquals( location.get( "type" ) , "Planet" ) );
		}

}
