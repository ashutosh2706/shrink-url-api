package io.spring.shrinkurl.model;

public class ErrorResponse {
	
	private String status;
	private String error;
	public ErrorResponse() {
		super();
	}
	public ErrorResponse(String status, String error) {
		super();
		this.status = status;
		this.error = error;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	@Override
	public String toString() {
		return "ErrorResponse [status=" + status + ", error=" + error + "]";
	}
	
}
