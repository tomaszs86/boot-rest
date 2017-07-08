package pl.boot.rest.handler;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import pl.boot.rest.domain.Event;

@Component
@RepositoryEventHandler(Event.class)
public class EventsHandler {

	  @HandleBeforeCreate
	  public void handleEventCreate(Event e) {
	    System.out.println("handleEventCreate");
	  }
	  
}
