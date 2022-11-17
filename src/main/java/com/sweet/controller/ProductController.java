package com.sweet.controller;

	import java.util.HashMap;
	import java.util.List;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
	
	import com.sweet.dto.ProductsList;
	import com.sweet.service.interfaces.IProductService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private IProductService productService;
	
	@GetMapping("/list")
	public ResponseEntity<List<ProductsList>> listAll(){
		HashMap<String, Object> response = new HashMap<String, Object>();
		response.put("products", productService.listAllProducts());
		return new ResponseEntity(response, HttpStatus.OK);
	}
}