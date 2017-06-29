package pl.boot.rest.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="sessions")
public class Session {

	@JsonIgnore
	@Id
	@Column(name="session_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sessions_seq")
	@SequenceGenerator(name = "sessions_seq", sequenceName = "sessions_seq_gen")
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="name", nullable = false)	
	private String name;
	
	@Column(name="presenter", nullable = false)	
	private String presenter;
	
	@Column(name="level", nullable = false)	
	private String level;
	
	@Column(name="abstraction", nullable = false)	
	private String abstraction;
	
	@Column(name="duration", nullable = false)	
	private Double duration;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name="event_id", nullable=false)
	private Event event;

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	
	
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPresenter() {
		return presenter;
	}

	public void setPresenter(String presenter) {
		this.presenter = presenter;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getAbstraction() {
		return abstraction;
	}

	public void setAbstraction(String abstraction) {
		this.abstraction = abstraction;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}		  
		  

		
	
	
	
}
