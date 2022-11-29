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
	
	import com.sweet.dto.RolUserDTO;
	import com.sweet.service.interfaces.IRolService;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "*")
public class RolController {
	@Autowired
	private IRolService rolService;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllRoles(){
		HashMap<String, Object> response = new HashMap<>();
		List<RolUserDTO> data = rolService.getRoles();
		if(data.size() > 0) {
			response.put("data", data);
		}else {
			response.put("message", "No existen roles registrados");
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
