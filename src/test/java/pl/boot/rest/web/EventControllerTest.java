package pl.boot.rest.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import pl.boot.rest.Application;
import pl.boot.rest.domain.Event;
import pl.boot.rest.domain.Location;
import pl.boot.rest.domain.Product;

import static org.assertj.core.api.BDDAssertions.then;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EventControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	private String url;
	
	private Event event;
	
	@Before
	public void init() {
		url = "http://localhost:8080/events/";
		
		event = new Event();
		event.setImageUrl("test");
		event.setName("test");
		event.setOnlineUrl("test");
		event.setDate(new Date());
		event.setPrice(0.00);
		event.setTime("test");
		
		Location location = new Location();
		location.setAddress("test");
		location.setCity("test");
		location.setCountry("test");
		
		event.setLocation(location);
	}

	@Test
	public void shouldReturn200WhenGettingEvents() throws Exception {
		
		ResponseEntity<Event[]> response = testRestTemplate.getForEntity(url, Event[].class);
		
		Object[] objects = response.getBody();
		HttpHeaders headers = response.getHeaders();
		HttpStatus statusCode = response.getStatusCode();
		
		then(statusCode).isEqualTo(HttpStatus.OK);
		then(objects).isNotEmpty();
		then(headers.getContentType().includes(MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void shouldReturn200WhenGettingFirstEvent() throws Exception {
		
		ResponseEntity<Event> response = testRestTemplate.getForEntity(url + "1", Event.class);
		then(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	public void shouldReturn201HttpStatusWhenCreateEvent() throws Exception {
		
		HttpEntity<Event> request = new HttpEntity<>(event);
		
		ResponseEntity<Event> response = testRestTemplate.exchange(url, HttpMethod.POST, request, Event.class);		  
		assertThat(response.getStatusCode(), is(HttpStatus.CREATED));
		  
		Event result = response.getBody();		  
		assertThat(result, notNullValue());
		assertThat(result.getName(), is("test"));		
	}
	
	@Test
	public void shouldReturnObjectWhenUpdateEvent() {
		
		event.setId(1);
		HttpEntity<Event> request = new HttpEntity<>(event);
		
		Event response = testRestTemplate.postForObject(url + "1", request, Event.class);		
		assertThat(response, notNullValue());						
	}
	
	@Test
	public void shouldReturn200HttpStatusWhenUpdateEvent() {

		event.setId(1);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Event> request = new HttpEntity<>(event, headers);		
		ResponseEntity<Event> response = testRestTemplate.exchange(url + "1", HttpMethod.PUT, request, Event.class);
		
		then(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
}
