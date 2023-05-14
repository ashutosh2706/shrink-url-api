package io.spring.shrinkurl.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Url {
	
	
	@Id
	@GeneratedValue
	private long id;
	@Lob
	private String originalUrl;
	private String shortUrl;
	private LocalDateTime creationDate;
	private LocalDateTime expirationDate;
	
	public Url(long id, String originalUrl, String shortUrl, LocalDateTime creationDate, LocalDateTime expirationDate) {
		super();
		this.id = id;
		this.originalUrl = originalUrl;
		this.shortUrl = shortUrl;
		this.creationDate = creationDate;
		this.expirationDate = expirationDate;
	}

	public Url() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOriginalUrl() {
		return originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDateTime getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDateTime expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Override
	public String toString() {
		return "Url [id=" + id + ", originalUrl=" + originalUrl + ", shortUrl=" + shortUrl + ", creationDate="
				+ creationDate + ", expirationDate=" + expirationDate + "]";
	}
	
	
}
