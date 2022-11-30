package com.sweet.utils;

import com.sweet.dto.ProductsList;
import com.sweet.entity.Product;

public class ProductsUtils {
	public static ProductsList maptoProductsList(Product product) {
		ProductsList products = new ProductsList();
		
		products.setProductId(product.getProductId());
		products.setDescription(product.getProductDescription());
		products.setName(product.getProductName());
		products.setPrice(product.getProductPrice());
		products.setImages(product.getImages());
		products.setStock(product.getProductStock());
		products.setCategory(product.getSubCategory().getCategory().getCategoryName());
		
		return products;
	}
}