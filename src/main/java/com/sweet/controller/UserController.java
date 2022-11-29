package com.sweet.controller;

	import java.util.HashMap;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.security.crypto.password.PasswordEncoder;
	import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
	
	import com.sweet.dto.SaveUserDTO;
	import com.sweet.entity.User;
	import com.sweet.service.interfaces.IUserService;

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
}