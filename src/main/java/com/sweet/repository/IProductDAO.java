package com.sweet.repository;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

	import com.sweet.entity.Product;
	
@Repository
public interface IProductDAO extends JpaRepository<Product, Long>{}