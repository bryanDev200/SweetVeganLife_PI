package com.sweet.service.interfaces;

	import java.util.List;
	
	import com.sweet.dto.ProductDTO;
	import com.sweet.dto.ProductsList;

public interface IProductService {
	public ProductDTO saveProduct();
	public List<ProductsList> listAllProducts();
}