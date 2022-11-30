package com.sweet.controller;

	import java.util.HashMap;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.mail.SimpleMailMessage;
	import org.springframework.mail.javamail.JavaMailSender;
	import org.springframework.security.crypto.password.PasswordEncoder;
	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
	
	import com.sweet.dto.ChangePasswordDTO;
	import com.sweet.dto.SaveUserDTO;
	import com.sweet.dto.SendEmailDTO;
	import com.sweet.entity.User;
	import com.sweet.service.interfaces.IUserService;
	import com.sweet.utils.UserModelMapper;

@RestController
@RequestMapping("/api/utils")
@CrossOrigin(origins = "*")
public class UtilsController {
	@Autowired
	private IUserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private JavaMailSender mail;
	
	@PutMapping("/resetPassword")
	public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDTO passwordDTO){
		HashMap<String, Object> response = new HashMap<>();
		User userFound = userService.getUserByUsername(passwordDTO.getEmail());	
					
		if(userFound != null) {
			if(passwordDTO.getPassword().equals(passwordDTO.getConfirmPassword())) {
				userFound.setPassword(passwordEncoder.encode(passwordDTO.getPassword()));
				SaveUserDTO save = UserModelMapper.mapToDto(userFound);
				String message = userService.updateUser(save, userFound.getUserId());
				response.put("message", message);
				return new ResponseEntity<>(response, HttpStatus.OK);
			}else {
				response.put("message", "Las contraseñas deben coincidir");
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
		}else {
			response.put("message", "No existe ninguna cuenta asociado a este correo");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/send")
	public ResponseEntity<?> sendMail(@RequestBody SendEmailDTO body){
		SimpleMailMessage email = new SimpleMailMessage();
		HashMap<String, Object> response = new HashMap<>();
		email.setTo(body.getEmail());
		email.setFrom("i201915077@cibertec.edu.pe");
		email.setSubject("Recuperar contraseña");
		email.setText("Haz click en el siguiente enlace para reestablecer tu contraseña: " +
					  "http://localhost:4200/recuperarPassword");
		
		try {
			mail.send(email);
			response.put("message", "Se ha enviado un correo para reestablecer la contraseña, verifique su bandeja de entrada.");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}catch(Exception e) {
			response.put("message", "Error: " + e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
}