package pl.boot.rest.projection;

import java.util.Date;

public interface EventWithoutDependencies {
	Integer getId();
	String getName();
	Date getDate();
	String getTime();
	Double getPrice();
	String getImageUrl();
	String getOnlineUrl();
}
