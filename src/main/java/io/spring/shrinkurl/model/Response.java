package io.spring.shrinkurl.model;

import java.time.LocalDateTime;

public class Response {
	
	private String originalUrl;
	private String shortUrl;
	private LocalDateTime expDate;
	
	
	public Response(String originalUrl, String shortUrl, LocalDateTime expDate) {
		super();
		this.originalUrl = originalUrl;
		this.shortUrl = shortUrl;
		this.expDate = expDate;
	}
	
	public Response() {
		super();
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
	
	public LocalDateTime getExpDate() {
		return expDate;
	}
	
	public void setExpDate(LocalDateTime expDate) {
		this.expDate = expDate;
	}
	
	@Override
	public String toString() {
		return "Response [originalUrl=" + originalUrl + ", shortUrl=" + shortUrl + ", expDate=" + expDate + "]";
	}

}
