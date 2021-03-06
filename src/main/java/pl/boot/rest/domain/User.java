package pl.boot.rest.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="users")
public class User {
	
	public void update(User user) {
		this.username = user.getUsername();
		this.isActive = user.getIsActive();
		this.created = user.getCreated();
	}
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
	@SequenceGenerator(name = "users_seq", sequenceName = "users_seq_gen")
	private Integer id;

	@NotNull(message = "Username is null")
	@NotEmpty(message = "Username is empty")
	@Column(name="username", nullable = false)
	private String username;
	
	@Column(name="is_active", nullable = false)	
	private Boolean isActive;
	
	@Column(name="created", nullable = false)	
	private Date created;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}	
}
