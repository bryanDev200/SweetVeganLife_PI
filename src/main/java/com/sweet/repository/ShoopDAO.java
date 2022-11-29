package com.sweet.repository;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;
	
	import com.sweet.entity.Shoop;

@Repository
public interface ShoopDAO extends JpaRepository<Shoop, Long>{}