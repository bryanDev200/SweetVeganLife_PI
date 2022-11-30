package com.sweet.controller;

	import java.util.HashMap;
	import java.util.List;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.RestController;

	import com.sweet.dto.ProductListItemDTO;
	import com.sweet.dto.ProductRegisterDTO;
	import com.sweet.entity.Product;
	import com.sweet.entity.ProductImage;
	import com.sweet.service.interfaces.IProductImageService;
	import com.sweet.service.interfaces.IProductService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private IProductService productService;
	@Autowired
	private IProductImageService piService;
	
	@GetMapping("/list")
	public ResponseEntity<?> listAll(){
		HashMap<String, Object> response = new HashMap<String, Object>();
		response.put("products", productService.listAllProductsOld());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> listAllProducts(){
		HashMap<String, Object> response = new HashMap<>();
		
		List<Product> data = productService.listAllProducts();
		
		response.put("data", data);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<?> getProduct(@PathVariable int id){
		HashMap<String, Object> response = new HashMap<>();
		
		Product product = productService.getProductById(id);
		
		if(product != null) {
			response.put("data", product);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}else {
			response.put("message", "Producto no encontrado");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findProducts")
	public ResponseEntity<?> getAllProductsFiler(@RequestParam(value = "productName", required = false, defaultValue = "") String productName,
			   @RequestParam(value = "subCategoryId", required = false, defaultValue = "-1") int subCategoryId){
		HashMap<String, Object> response = new HashMap<>();
		
		List<ProductListItemDTO> data = productService.getAllProducts("%" + productName + "%", subCategoryId);
		
		response.put("data", data);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveProduct(@RequestBody ProductRegisterDTO bean){
		HashMap<String, Object> response = new HashMap<>();
		Product product = productService.saveProduct(bean);
				
		if(product != null) {
			ProductImage pi = piService.saveImage(bean.getUrlImage(), (int)product.getProductId());
			response.put("message", "Producto registrado correctamente");
			response.put("productId", product.getProductId());
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		}else {
			response.put("message", "Error al registrar el producto");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable int id){
		HashMap<String, Object> response = new HashMap<>();
		
		String messageDeleted= productService.deleteProduct(id);
		
		response.put("message", messageDeleted);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable int id, @RequestBody ProductRegisterDTO bean){
		HashMap<String, Object> response = new HashMap<>();
		String messageUpdated = productService.updateProduct(bean, id);
		Product product = productService.getProductById(id);
		
		response.put("message", messageUpdated);
		response.put("productId", product.getProductId());

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}