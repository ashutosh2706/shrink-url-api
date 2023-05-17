package io.spring.shrinkurl.model;

import java.time.LocalDateTime;

public class Response {

	private int code = 200;
	private String status = "OK";
	private String originalUrl = null;
	private String shortUrl = null;
	private LocalDateTime expDate = null;

	public Response(int code, String status, String originalUrl, String shortUrl, LocalDateTime expDate) {
		super();
		this.code = code;
		this.status = status;
		this.originalUrl = originalUrl;
		this.shortUrl = shortUrl;
		this.expDate = expDate;
	}

	public Response() {
		super();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		return "Response [code=" + code + ", status=" + status + ", originalUrl=" + originalUrl + ", shortUrl="
				+ shortUrl + ", expDate=" + expDate + "]";
	}

}
