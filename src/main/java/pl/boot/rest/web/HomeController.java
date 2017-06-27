package pl.boot.rest.web;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import pl.boot.rest.domain.User;

@RestController
public class HomeController {

	private final JdbcTemplate jdbcTemplate;
	private final RestTemplate restTemplate;

	public HomeController(JdbcTemplate jdbcTemplate, RestTemplateBuilder restTemplateBuilder) {
		this.jdbcTemplate = jdbcTemplate;
		this.restTemplate = restTemplateBuilder.build();
	}
	
	@RequestMapping(value = "/")
	public String home() {
		
		ResponseEntity<User[]> responseEntity = this.restTemplate.getForEntity("http://localhost:8080/users", User[].class);
		User[] result = responseEntity.getBody();
		MediaType contentType = responseEntity.getHeaders().getContentType();
		HttpStatus statusCode = responseEntity.getStatusCode();
		
		return "Hello World!!";
	}
}
