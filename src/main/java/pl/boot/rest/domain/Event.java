package pl.boot.rest.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="events")
public class Event {
	
	public Event() {
		sessions = new ArrayList<Session>();
	}
	
	public void update(Event event) {
		date = event.getDate();
		imageUrl = event.getImageUrl();				
		name = event.getName();
		onlineUrl = event.getOnlineUrl();
		price = event.getPrice();
		time = event.getTime();		 
		sessions.clear();
		  
	}
	
	@Id
	@Column(name="event_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "events_seq")
	@SequenceGenerator(name = "events_seq", sequenceName = "events_seq_gen")
	private Integer id;
	
	@NotNull(message = "Name is null")
	@NotEmpty(message = "Name is empty")
	@Column(name="name", nullable = false)
	private String name;
	
	@Column(name="date", nullable = false)	
	private Date date;
	
	@Column(name="time", nullable = false)	
	private String time;
	
	@Column(name="price", nullable = false)	
	private Double price;
	
	@Column(name="image_url", nullable = false)	
	private String imageUrl;
	
	@Column(name="online_url", nullable = true)	
	private String onlineUrl;

	@OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
	private Location location;
	
	@OneToMany(mappedBy="event", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, orphanRemoval=true) 
	private List<Session> sessions;

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getOnlineUrl() {
		return onlineUrl;
	}

	public void setOnlineUrl(String onlineUrl) {
		this.onlineUrl = onlineUrl;
	}
}
