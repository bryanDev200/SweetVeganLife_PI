package com.sweet.controller;

	import java.util.HashMap;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	import com.sweet.dto.ProductResponse;
	import com.sweet.service.interfaces.IProductService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private IProductService productService;
	
	@PostMapping("/getProductDetail/{id}")
	public ResponseEntity<?> getProductDetail(@PathVariable long id){
		HashMap<String, Object> response = new HashMap<>();
		ProductResponse product = productService.getProductById(id);
		if(product == null) {
			response.put("message", "Producto no encontrado");
		}else {
			response.put("data", product);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}