package com.sweet.service.interfaces;

	import com.sweet.dto.ProductDTO;
import com.sweet.dto.ProductResponse;
import com.sweet.entity.Product;
	import java.util.List;
	
	import com.sweet.dto.ProductDTO;
	import com.sweet.dto.ProductsList;

public interface IProductService {
	public Product saveProduct(ProductDTO product);
	public ProductResponse getProductById(long id);
	public List<ProductsList> listAllProducts();
}