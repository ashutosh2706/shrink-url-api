package io.spring.shrinkurl.model;

public class Request {

	private String url;
	private String expDate;
	
	public Request() {
		super();
	}
	
	public Request(String url, String expDate) {
		super();
		this.url = url;
		this.expDate = expDate;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getExpDate() {
		return expDate;
	}
	
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	
	@Override
	public String toString() {
		return "Request [url=" + url + ", expDate=" + expDate + "]";
	}
	
}
