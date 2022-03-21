package com.victor.bedsideencourager.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="patients")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Name of Patient is required!")
	@Size(min=3, max=30, message="Patient name must be between 3 and 30 characters")
	private String name;
	
	@NotNull(message="Must not be blank.")
	@Min(value=0, message="Must be greater than zero.")
	private Double age;
	
	@NotNull(message="Must not be blank.")
	@Min(value=100, message="There is no Room number lower than 100.")
	@Max(value=600, message="There is no Room number greater than 600.")
	private Double roomNumber;
	
	@NotEmpty(message="Description is required!")
	@Size(min=10, max=300, message="Description must be between 10 and 300 characters")
	private String description;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(mappedBy="recipient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<PosterRecipient> postersRecipients;
	
	public Patient() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAge() {
		return age;
	}

	public void setAge(Double age) {
		this.age = age;
	}

	public Double getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Double roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<PosterRecipient> getPostersRecipients() {
		return postersRecipients;
	}

	public void setPostersRecipients(List<PosterRecipient> postersRecipients) {
		this.postersRecipients = postersRecipients;
	}
}
