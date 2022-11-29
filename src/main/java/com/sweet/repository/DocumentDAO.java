package com.sweet.repository;

	import org.springframework.data.jpa.repository.JpaRepository;
	
	import org.springframework.stereotype.Repository;

	import com.sweet.entity.Document;

@Repository
public interface DocumentDAO extends JpaRepository<Document, Long> {
	
}