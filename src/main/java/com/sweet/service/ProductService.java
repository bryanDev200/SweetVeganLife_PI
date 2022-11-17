package com.sweet.service;

	import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	
	import com.sweet.dto.ProductDTO;
	import com.sweet.dto.ProductsList;
	import com.sweet.repository.IProductDAO;
	import com.sweet.service.interfaces.IProductService;
import com.sweet.utils.ProductsUtils;

@Service
public class ProductService implements IProductService {
	@Autowired
	private IProductDAO productDAO;
	
	@Override
	public ProductDTO saveProduct() {
		return null;
	}

	@Override
	public List<ProductsList> listAllProducts() {
		List<ProductsList> list = productDAO.listAllProducts()
				.stream().map((product) -> ProductsUtils.maptoProductsList(product)).collect(Collectors.toList());
		return list;
	}
}