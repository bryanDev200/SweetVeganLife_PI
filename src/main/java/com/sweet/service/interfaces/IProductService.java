package com.sweet.service.interfaces;

	import java.util.List;
	
	import com.sweet.dto.ProductListItemDTO;
	import com.sweet.dto.ProductRegisterDTO;
import com.sweet.dto.ProductsList;
import com.sweet.entity.Product;

public interface IProductService {
	public Product saveProduct(ProductRegisterDTO bea);
	public Product getProductById(long id);
	public String updateProduct(ProductRegisterDTO bea, int id);
	public String deleteProduct(int id);
	public List<ProductListItemDTO> getAllProducts(String names, int id);
	public List<Product> listAllProducts();
	public List<ProductsList> listAllProductsOld();
}