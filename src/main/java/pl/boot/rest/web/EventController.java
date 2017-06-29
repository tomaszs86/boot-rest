package pl.boot.rest.web;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;

import pl.boot.rest.domain.Event;
import pl.boot.rest.domain.Location;
import pl.boot.rest.exception.EventNotFoundException;
import pl.boot.rest.exception.MyException;
import pl.boot.rest.repository.EventRepository;

@RestController
@RequestMapping("/events")
public class EventController {

	@Autowired
	private EventRepository eventRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Event> getEvents() {	
		
		return eventRepository.findAll();		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Event getEvent(@PathVariable("id") Integer id) {		
		
		Event event = eventRepository.findOne(id);			
		
		if (event == null) throw new EventNotFoundException(id.toString());		
		return event;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)	
    public Integer create(@Valid @RequestBody Event resource) {
      
		if(resource == null) throw new MyException("example");		
	
		Location location = resource.getLocation();
		location.setEvent(resource);
		
		Event event = eventRepository.save(resource);		
		return event.getId();	
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") Integer id) {
	
		eventRepository.delete(id);
	}
	
   @RequestMapping( value = "/{id}", method = RequestMethod.PUT )
   @ResponseStatus( HttpStatus.OK )
   public void update( @PathVariable("id") Integer id, @Valid @RequestBody Event resource ){

	  if(resource == null) throw new EventNotFoundException(id.toString());
	  
	  Event event = eventRepository.findOne(id);			
		
	  if (event == null) throw new EventNotFoundException(id.toString());	
	  
	  event.setDate(resource.getDate());
	  event.setImageUrl(resource.getImageUrl());
	  event.setName(resource.getName());
	  event.setOnlineUrl(resource.getOnlineUrl());
	  event.setPrice(resource.getPrice());
	  event.setTime(resource.getTime());
	  
	  Location location = event.getLocation();
	  location.setAddress(resource.getLocation().getAddress());
	  location.setCity(resource.getLocation().getCity());
	  location.setCountry(resource.getLocation().getCountry());
	
	  eventRepository.save(event);
   }	
}
