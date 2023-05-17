package io.spring.shrinkurl.controller;

import java.time.LocalDateTime;
import java.util.List;

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
	public String homePage() {
		return "Shrink Url Service Started and Running...";
	}

	@GetMapping("/list")
	public List<Url> listAll() {
		return this.service.getAllUrls();
	}

	@PostMapping("/shrink")
	public ResponseEntity<?> shrinkUrl(@RequestBody Request request) {

		Url url = this.service.generateShortUrl(request);
		if (url != null) {
			Response response = new Response();
			response.setOriginalUrl(request.getUrl());
			response.setShortUrl(url.getShortUrl());
			response.setExpDate(url.getExpirationDate());
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}

		// error response
		Response errorResponse = new Response();
		errorResponse.setCode(500);
		errorResponse.setStatus("INTERNAL_SERVER_ERROR");
		return new ResponseEntity<Response>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@GetMapping("/{uid}")
	public ResponseEntity<?> redirectToUrl(@PathVariable String uid) {

		if (StringUtils.isEmpty(uid)) {
			Response errorResponse = new Response();
			errorResponse.setCode(400);
			errorResponse.setStatus("BAD_REQUEST");
			return new ResponseEntity<Response>(errorResponse, HttpStatus.BAD_REQUEST);
		}

		Url url = this.service.getEncodedUrl(uid);
		if (url == null) {
			Response errorResponse = new Response();
			errorResponse.setCode(404);
			errorResponse.setStatus("NOT_FOUND");
			return new ResponseEntity<Response>(errorResponse, HttpStatus.NOT_FOUND);
		}

		// check for expired uid

		if (url.getExpirationDate().isBefore(LocalDateTime.now())) {
			Response errorResponse = new Response();
			errorResponse.setCode(410);
			errorResponse.setStatus("GONE");
			return new ResponseEntity<Response>(errorResponse, HttpStatus.GONE);
		}

		Response response = new Response();
		response.setOriginalUrl(url.getOriginalUrl());
		response.setShortUrl(url.getShortUrl());
		response.setExpDate(url.getExpirationDate());
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}

}
