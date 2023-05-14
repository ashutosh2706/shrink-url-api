package io.spring.shrinkurl.controller;

import java.time.LocalDateTime;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.spring.shrinkurl.model.*;
import io.spring.shrinkurl.service.ShrinkService;

@RestController
@EntityScan("io.spring.shrinkurl.model")
public class AppController {
	
	@Autowired
	private ShrinkService service;
	
	@GetMapping("/")
	public String show() {
		return "Shrink Url Service Started and Running...";
	}
	
	@PostMapping("/shrink")
	public ResponseEntity<?> shrinkUrl(@RequestBody Request request) {
		
		Url url = this.service.generateShortUrl(request);
		if(url != null) {
			Response response = new Response();
			response.setOriginalUrl(request.getUrl());
			response.setShortUrl(url.getShortUrl());
			response.setExpDate(url.getExpirationDate());
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}
		
		// error response
		ErrorResponse  errorResponse = new ErrorResponse();
		errorResponse.setStatus("404");
		errorResponse.setError("Internal Error");
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@GetMapping("/{uid}")
	public ResponseEntity<?> redirectToUrl(@PathVariable String uid) {
		
		if(StringUtils.isEmpty(uid)) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setStatus("404");
			errorResponse.setError("Invalid UID");
			return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
		}
		
		Url url = this.service.getEncodedUrl(uid);
		if(url == null) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setStatus("404");
			errorResponse.setError("UID Not Found");
			return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
		}
		// check for expired uid
		
		if(url.getExpirationDate().isBefore(LocalDateTime.now())) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setStatus("200");
			errorResponse.setError("Link Expired");
			return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);
		}
		
		Response response = new Response();
		response.setOriginalUrl(url.getOriginalUrl());
		response.setShortUrl(url.getShortUrl());
		response.setExpDate(url.getExpirationDate());
		return new ResponseEntity<Response>(response, HttpStatus.OK);
		
	}
	
}
