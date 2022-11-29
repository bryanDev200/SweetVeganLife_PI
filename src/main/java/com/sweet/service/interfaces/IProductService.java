package com.sweet.service.interfaces;

	import com.sweet.dto.ProductDTO;
import com.sweet.dto.ProductResponse;
import com.sweet.entity.Product;

public interface IProductService {
	public Product saveProduct(ProductDTO product);
	public ProductResponse getProductById(long id);
}