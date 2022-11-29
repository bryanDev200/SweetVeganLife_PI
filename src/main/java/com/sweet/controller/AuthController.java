package com.sweet.controller;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.security.authentication.AuthenticationManager;
	import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
	import org.springframework.security.core.Authentication;
	import org.springframework.security.core.context.SecurityContextHolder;
	import org.springframework.security.crypto.password.PasswordEncoder;
	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

	import com.sweet.dto.JwtRequest;
	import com.sweet.dto.JwtResponse;
import com.sweet.entity.User;
import com.sweet.repository.UserDAO;
	import com.sweet.security.JwtTokenProvider;
import com.sweet.service.interfaces.IUserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	@Autowired
	private IUserService service;
	
	@PostMapping("/iniciarSesion")
	public ResponseEntity<JwtResponse> authenticateUser(@RequestBody JwtRequest loginDTO){
		Authentication authentication = authenticationManager
										.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), 
																						      loginDTO.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = jwtTokenProvider.generarToken(authentication);
		User user = service.getUserByUsername(loginDTO.getUsername());
		JwtResponse response = new JwtResponse(token);
		response.setFirstName(user.getUserFirstNames());
		response.setLastName(user.getUserLastName());
		response.setPhone(user.getUserPhone());
		response.setImage(user.getUserImage());
		response.setUsername(user.getUserName());
		response.setRol(user.getUserRol());
		response.setId(user.getUserId());
		
		return ResponseEntity.ok(response);
	}
}