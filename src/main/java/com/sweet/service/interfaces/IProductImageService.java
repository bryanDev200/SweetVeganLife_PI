package com.sweet.service.interfaces;

	import com.sweet.entity.ProductImage;

public interface IProductImageService {
	public ProductImage saveImage(String url, int id);
	public ProductImage getImageByProductId(long productId);
	public void deleteImage(long id);
}