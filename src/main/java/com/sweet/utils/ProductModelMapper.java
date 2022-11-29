package com.sweet.utils;

	import java.util.stream.Collectors;
	
	import com.sweet.dto.ProductResponse;
	import com.sweet.entity.Product;

public class ProductModelMapper {
	public static ProductResponse mapToDto(Product product) {
		ProductResponse response = new ProductResponse();
		
		response.setId(product.getProductId());
		response.setDescription(product.getProductDescription());
		response.setProductName(product.getProductName());
		response.setPrice(product.getProductPrice());
		response.setStock(product.getProductStock());
		response.setCategory(product.getSubCategory().getCategory().getCategoryName());
		response.setImages(product.getImages().stream().map((image) -> image.getImageUrl()).collect(Collectors.toSet()));
		
		return response;
	}
}