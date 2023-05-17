package io.spring.shrinkurl.service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.hash.Hashing;

import io.spring.shrinkurl.dao.UrlDao;
import io.spring.shrinkurl.model.Url;
import io.spring.shrinkurl.model.Request;

@Component
public class ShrinkServiceImpl implements ShrinkService{
	
	@Autowired
	private UrlDao repo;

	@Override
	public Url generateShortUrl(Request request) {
		
		if(StringUtils.isNotEmpty(request.getUrl())) {
			
			String str = request.getUrl();
			LocalDateTime time = LocalDateTime.now();
			String uid = Hashing.murmur3_32().hashString(str.concat(time.toString()), StandardCharsets.UTF_8).toString();
			
			Url obj = new Url();
			obj.setCreationDate(LocalDateTime.now());
			obj.setShortUrl(uid);
			obj.setOriginalUrl(request.getUrl());
			obj.setExpirationDate(expirationDate(request.getExpDate(), obj.getCreationDate()));
			Url url = persistShortUrl(obj);
			
			return url != null ? url : null;
		}
		return null;
	}

	@Override
	public Url persistShortUrl(Url url) {
		// save into database
		return repo.save(url);
	}

	@Override
	public Url getEncodedUrl(String url) {
		// get Back original url
		return repo.findByShortUrl(url);
	}

	@Override
	public void deleteShortUrl(Url url) {
		repo.delete(url);
	}
	
	@Override
	public List<Url> getAllUrls() {
		return repo.findAll();
	}
	
	private LocalDateTime expirationDate(String givenTime, LocalDateTime creationTime) {
		if(StringUtils.isBlank(givenTime)) {
			return creationTime.plusDays(7);
		}
		return LocalDateTime.parse(givenTime);
	}

}
