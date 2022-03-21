package com.victor.bedsideencourager.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="posters_recipients")
public class PosterRecipient {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @NotEmpty(message="Word can not be empty!")
	@Size(min=10, max=300, message="Description must be between 10 and 300 characters")
	private String word;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="poster_id")
    private User poster;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="recipient_id")
    private Patient recipient;
    
    public PosterRecipient( ) {
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public User getPoster() {
		return poster;
	}

	public void setPoster(User poster) {
		this.poster = poster;
	}

	public Patient getRecipient() {
		return recipient;
	}

	public void setRecipient(Patient recipient) {
		this.recipient = recipient;
	}

}
