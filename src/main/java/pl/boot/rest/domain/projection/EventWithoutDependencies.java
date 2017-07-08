package pl.boot.rest.domain.projection;

import java.util.Date;

import org.springframework.data.rest.core.config.Projection;

import pl.boot.rest.domain.Event;

@Projection(name = "noDependencies", types = { Event.class }) 
public interface EventWithoutDependencies {
	Integer getId();
	String getName();
	Date getDate();
	String getTime();
	Double getPrice();
	String getImageUrl();
	String getOnlineUrl();
}
