package pl.boot.rest.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import pl.boot.rest.Application;
import pl.boot.rest.domain.Product;

import static org.assertj.core.api.BDDAssertions.then;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EventControllerTest {

	
	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void shouldReturn200WhenSendingRequestToController() throws Exception {
		
		ResponseEntity<Product> entity = this.testRestTemplate.getForEntity(
				"http://localhost:8080/events/1", Product.class);

		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
}
