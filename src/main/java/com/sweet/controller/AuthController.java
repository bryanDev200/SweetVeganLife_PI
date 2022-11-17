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
	import com.sweet.repository.IUserDAO;
	import com.sweet.security.JwtTokenProvider;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@PostMapping("/iniciarSesion")
	public ResponseEntity<JwtResponse> authenticateUser(@RequestBody JwtRequest loginDTO){
		Authentication authentication = authenticationManager
										.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), 
																						      loginDTO.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		//obtenemos el token del jwtTokenProvider
		String token = jwtTokenProvider.generarToken(authentication);
		return ResponseEntity.ok(new JwtResponse(token));
	}
}