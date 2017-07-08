package pl.boot.rest.web;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.boot.rest.domain.Event;

@RepositoryRestController
@RequestMapping("/api/custom")
public class CustomRestController {

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	    public @ResponseBody ResponseEntity<?> getProducers() {
	        
		   Event event = new Event();
		   Resource<Event> resources = new Resource<>(event); 

	        return ResponseEntity.ok(resources); 
	    }
}
