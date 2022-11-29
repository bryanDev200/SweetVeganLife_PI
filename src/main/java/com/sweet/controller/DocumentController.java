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

import com.sweet.dto.DocumentUserDTO;
import com.sweet.service.interfaces.IDocumentService;

@RestController
@RequestMapping("/api/document")
@CrossOrigin(origins = "*")
public class DocumentController {
	@Autowired
	private IDocumentService docService;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllDocs(){
		HashMap<String, Object> response = new HashMap<>();
		List<DocumentUserDTO> data = docService.getDocuments();
		if(data.size() > 0) {
			response.put("data", data);
		}else {
			response.put("message", "No existen documentos registrados");
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
