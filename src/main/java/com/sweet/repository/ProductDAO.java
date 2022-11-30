package com.sweet.repository;

	import java.util.List;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Query;
	import org.springframework.stereotype.Repository;

	import com.sweet.entity.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long>{
	@Query("select p from Product p where (p.productName like ?1) and (?2 is -1 or p.subCategory.subCategoryId = ?2)")
	public List<Product> getAllProducts(String name, int categoryId);
	
	@Query(value = "{call list_all_products() }", nativeQuery = true)
	public List<Product> listAllProducts();
}