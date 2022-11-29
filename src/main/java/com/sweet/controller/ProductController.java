package com.sweet.controller;

	import java.io.IOException;
	import java.nio.file.Files;
	import java.nio.file.Path;
	import java.nio.file.Paths;
	import java.util.HashMap;
	import java.util.List;
	import java.util.UUID;
	
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
	import org.springframework.web.multipart.MultipartFile;

	import com.sweet.dto.ProductListItemDTO;
	import com.sweet.dto.ProductRegisterDTO;
	import com.sweet.entity.Product;
	import com.sweet.service.interfaces.IProductService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private IProductService productService;
	/*@Autowired
	private IProductImageService piService;*/
	
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
		
		//ProductImage pi = piService.getImageByProductId((long)id);
		String messageDeleted= productService.deleteProduct(id);
		
		/*if(pi != null) {
			Path lastFile = Paths.get("uploads").resolve(pi.getImageUrl()).toAbsolutePath();
			File fileDel = lastFile.toFile();
			if(fileDel.exists() && fileDel.canRead()) {
				fileDel.delete();
			}
		}*/
		
		response.put("message", messageDeleted);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/upload")
	public ResponseEntity<?> uploadProductImage(@RequestParam("file") MultipartFile file,
												@RequestParam("id") int id){
		HashMap<String, Object> response = new HashMap<>();

		if(!file.isEmpty()) {
			String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename().replace(" ", "");
			Path filePath = Paths.get("uploads").resolve(fileName).toAbsolutePath();
			
			try {
				Files.copy(file.getInputStream(), filePath);
			} catch (IOException e) {
				response.put("message", "Error al cargar la imagen");
				return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			//ProductImage pi = piService.getImageByProductId((long)id);
			
			/*if(pi != null) {
				Path lastFile = Paths.get("uploads").resolve(pi.getImageUrl()).toAbsolutePath();
				File fileDel = lastFile.toFile();
				if(fileDel.exists() && fileDel.canRead()) {
					fileDel.delete();
				}
				//piService.deleteImage(pi.getImageId());
			}*/
			
			//piService.saveImage(fileName, id);
			response.put("message", "imagen cargada correctamente");
		}
		
		return new ResponseEntity<>(response, HttpStatus.CREATED);
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