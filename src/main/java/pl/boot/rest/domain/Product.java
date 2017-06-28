package pl.boot.rest.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="products")
public class Product {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products_seq")
	@SequenceGenerator(name = "products_seq", sequenceName = "products_seq_gen")
	private Integer id;
	
	@NotNull(message = "Name is null")
	@NotEmpty(message = "Name is empty")
	@Column(name="product_name", nullable = false)
	private String productName;
	
	@NotNull(message = "Code is null")
	@NotEmpty(message = "Code is empty")
	@Column(name="product_code", nullable = false)
	private String productCode;
	
	@Column(name="release_date", nullable = false)	
	private Date releaseDate;
	
	@Column(name="price", nullable = false)	
	private Double price;
	
	@Column(name="description", nullable = false)	
	private String description;
	
	@Column(name="star_rating", nullable = false)	
	private Integer starRating;
	
	@JsonIgnore
	@Column(name="tags", nullable = true)	
	private String dbTags;
	
	public String getDbTags() {
		return dbTags;
	}

	public void setDbTags(String dbTags) {
		this.dbTags = dbTags;
	}

	@Transient
	private List<String> tags;
	
	public List<String> getTags() {
		
		if(dbTags == null)
			return new ArrayList<>();		
		
		return Arrays.asList(dbTags.split(","));
	}

	public void setTags(List<String> tags) {
		this.dbTags = String.join(",", tags);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStarRating() {
		return starRating;
	}

	public void setStarRating(Integer starRating) {
		this.starRating = starRating;
	}
}
