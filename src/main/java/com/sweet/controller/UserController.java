package com.sweet.controller;

	import java.io.File;
	import java.nio.file.Path;
	import java.nio.file.Paths;
	import java.util.HashMap;
	import java.util.List;
		
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
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

import com.sweet.dto.SendEmailDTO;
import com.sweet.dto.ChangePasswordDTO;
import com.sweet.dto.SaveUserDTO;
	import com.sweet.dto.UserListItemDTO;
	import com.sweet.entity.User;
	import com.sweet.service.interfaces.IUserService;
import com.sweet.utils.UserModelMapper;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private IUserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/register")
	public ResponseEntity<?> registerNewUser(@RequestBody SaveUserDTO user) {
		HashMap<String, Object> response = new HashMap<>();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User userResponse = userService.saveUser(user);
		if (userResponse == null) {
			response.put("message", "Error al crear el usuario");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			response.put("message", "Usuario registrado");
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		}
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<?> updateUser(@PathVariable long id, @RequestBody SaveUserDTO user){
		HashMap<String, Object> response = new HashMap<>();
		String message = userService.updateUser(user, id);
		response.put("message", message);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable int id){
		HashMap<String, Object> response = new HashMap<>();
		
		User user = userService.getUserById(id);
		String messageDeleted= userService.deleteUser(id);
		
		String nameLastImage = user.getUserImage();
		
		if(nameLastImage != null && nameLastImage.length() > 0) {
			Path lastFilePath = Paths.get("uploads").resolve(nameLastImage).toAbsolutePath();
			File fileLastImage = lastFilePath.toFile();
			if(fileLastImage.exists() && fileLastImage.canRead()) {
				fileLastImage.delete();
			}
		}
		
		response.put("message", messageDeleted);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getUserById(@PathVariable int id){
		HashMap<String, Object> response = new HashMap<>();
		User user = userService.getUserById(id);
		
		if(user != null){
			response.put("user", user);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}else {
			response.put("message", "Usuario no encontrado");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findUsers")
	public ResponseEntity<?> listaAlumnosPorFiltros(@RequestParam(value = "names", required = false, defaultValue = "") String names,
											   @RequestParam(value = "rolId", required = false, defaultValue = "-1") int rolId,
											   @RequestParam(value = "shoopId", required = false, defaultValue = "-1") int shoopId){
		HashMap<String, Object> response = new HashMap<>();
		
		List<UserListItemDTO> data = userService.getAllUsers("%" + names + "%", rolId, shoopId);
		
		response.put("data", data);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}