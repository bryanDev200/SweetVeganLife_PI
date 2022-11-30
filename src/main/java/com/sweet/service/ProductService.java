package com.sweet.service;

	import java.util.List;
	import java.util.stream.Collectors;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.sweet.dto.ProductListItemDTO;
	import com.sweet.dto.ProductRegisterDTO;
import com.sweet.dto.ProductsList;
import com.sweet.entity.Product;
	import com.sweet.entity.SubCategory;
	import com.sweet.entity.Supplier;
	import com.sweet.repository.ProductDAO;
	import com.sweet.service.interfaces.IProductService;
import com.sweet.utils.ProductsUtils;

@Service
public class ProductService implements IProductService {
	@Autowired
	private ProductDAO repo;
	
	@Override
	public Product saveProduct(ProductRegisterDTO bean) {
		Product product = new Product();
		
		product.setProductDescription(bean.getDescription());
		product.setProductName(bean.getName());
		product.setProductPrice(bean.getPrice());
		product.setProductStock(bean.getStock());
		product.setSubCategory(new SubCategory(bean.getSubcategoryId()));
		product.setSupplier(new Supplier(bean.getSupplierId()));
		product.setProductState(bean.isEnabled());
		
		Product productSaved = repo.save(product);
		
		return productSaved;
	}

	@Override
	public Product getProductById(long id) {
		try {
			Product productFound = repo.findById(id).get();
			return productFound;
		}catch(Exception e) {
			return null;
		}
	}

	@Override
	public List<ProductListItemDTO> getAllProducts(String names, int id) {
		List<ProductListItemDTO> data = repo.getAllProducts(names, id).stream()
				.map((product) -> new ProductListItemDTO((int)product.getProductId(),
						product.getProductName(), product.getProductPrice(),
						product.getSubCategory().getSubCategoryName()))
				.collect(Collectors.toList());
		return data;
	}

	@Override
	public List<Product> listAllProducts() {
		return repo.findAll();
	}

	@Override
	public String updateProduct(ProductRegisterDTO bea, int id) {
		Product product = repo.findById((long)id).orElse(null);
		if(product != null) {
			product.setProductDescription(bea.getDescription());
			product.setProductName(bea.getName());
			product.setProductPrice(bea.getPrice());
			product.setProductStock(bea.getStock());
			product.setSubCategory(new SubCategory(bea.getSubcategoryId()));
			product.setSupplier(new Supplier(bea.getSupplierId()));
			product.setProductState(bea.isEnabled());
			
			Product productSave = repo.save(product);
			if(productSave == null) {
				return "Error al actualizar los datos";
			}else {
				return "El producto " + bea.getName() + " ha sido editado correctamente";
			}
		}else {
			return "El producto no ha sido encontrado";
		}
	}

	@Override
	public String deleteProduct(int id) {
		Product productFound = repo.findById((long)id).orElse(null);
		
		if(productFound != null) {
			try {
				repo.deleteById((long)id);
				return "Producto eliminado correctamente";
			}catch(Exception e) {
				return "Error al eliminar el producto";
			}
		}else {
			return "El producto no ha sido encontrado";
		}
	}

	@Override
	public List<ProductsList> listAllProductsOld() {
		List<ProductsList> list = repo.listAllProducts()
				.stream().map((product) -> ProductsUtils.maptoProductsList(product)).collect(Collectors.toList());
		return list;
	}	
}