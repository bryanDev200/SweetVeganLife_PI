package com.sweet.service;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	
	import com.sweet.dto.ProductDTO;
	import com.sweet.dto.ProductResponse;
	import com.sweet.entity.Product;
	import com.sweet.repository.IProductDAO;
	import com.sweet.service.interfaces.IProductService;
import com.sweet.utils.ProductModelMapper;

@Service
public class ProductService implements IProductService {
	@Autowired
	private IProductDAO productDAO;
	
	@Override
	public Product saveProduct(ProductDTO product) {
		return null;
	}

	@Override
	public ProductResponse getProductById(long id) {
		Product product = productDAO.findById(id).get();
		ProductResponse response = ProductModelMapper.mapToDto(product);
		return response;
	}
	
}