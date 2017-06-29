package pl.boot.rest.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="locations")
public class Location {

	
	
	@Id 
	@Column(name="location_id") 
	private Integer id;
	
	@Column(name="address", nullable = false)	
	private String address;
	
	@Column(name="city", nullable = false)	
	private String city;
	
	@Column(name="country", nullable = false)	
	private String country;

	@MapsId 
    @OneToOne(mappedBy = "location")
    @JoinColumn(name = "event_id")
	@JsonIgnore
	private Event event;

	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}	
}
