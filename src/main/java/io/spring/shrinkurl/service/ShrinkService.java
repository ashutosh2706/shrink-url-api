package io.spring.shrinkurl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.spring.shrinkurl.model.Url;
import io.spring.shrinkurl.model.Request;

@Service
public interface ShrinkService {

	public Url generateShortUrl(Request request);
	public Url persistShortUrl(Url url);
	public Url getEncodedUrl(String Url);
	public void deleteShortUrl(Url url);
	public List<Url> getAllUrls();
}
