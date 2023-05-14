package io.spring.shrinkurl.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.spring.shrinkurl.model.Url;

@Repository
public interface UrlDao extends JpaRepository<Url, Long> {
	
	public Url findByShortUrl(String shortUrl);
}
