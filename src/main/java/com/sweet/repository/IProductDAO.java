package com.sweet.repository;

	import java.util.List;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Query;
	import org.springframework.stereotype.Repository;

	import com.sweet.entity.Product;
	
@Repository
public interface IProductDAO extends JpaRepository<Product, Long>{
	@Query(value = "{call list_all_products() }", nativeQuery = true)
	public List<Product> listAllProducts();
}