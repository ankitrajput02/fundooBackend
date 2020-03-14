package com.bridgelabz.fundoonotesapi.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundoonotesapi.dto.ForgotPasswordDTO;
import com.bridgelabz.fundoonotesapi.dto.LoginDTO;
import com.bridgelabz.fundoonotesapi.dto.RegistrationDTO;
import com.bridgelabz.fundoonotesapi.dto.ResetPasswordDTO;
import com.bridgelabz.fundoonotesapi.service.UserService;

@RestController
@RequestMapping("/userapi")
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping("/adduser")
	public ResponseEntity<String> addUser(RegistrationDTO registrationDTO) {
		Response response = service.addUser(registrationDTO);
		return new ResponseEntity<String>(response.getMessage(), HttpStatus.OK);

	}

	@PostMapping("/login")
	public ResponseEntity<String> login(LoginDTO loginDTO) {
		Response response = service.login(loginDTO);
		return new ResponseEntity<String>(response.getMessage(), HttpStatus.OK);
	}

	@PostMapping("/validate")
	public ResponseEntity<String> validateUser(String token) {
		Response response = service.validateUser(token);
		return new ResponseEntity<String>(response.getMessage(), HttpStatus.OK);
	}

	public ResponseEntity<String> deleteUser(String token) {
		Response response = service.deleteUser(token);
		return new ResponseEntity<String>(response.getMessage(), HttpStatus.OK);

	}

	public ResponseEntity<String> signOut(String token) {
		Response response = service.signOut(token);
		return new ResponseEntity<String>(response.getMessage(), HttpStatus.OK);
	}

	@GetMapping("/getusers")
	public ResponseEntity<String> getUser() {
		Response response = service.getUser();
		return new ResponseEntity<String>(response.getMessage(), HttpStatus.OK);
	}

	@PutMapping("/resetpassword")
	public ResponseEntity<String> resetPassword(String token, ResetPasswordDTO resetPasswordDTO) {
		Response response = service.resetPassword(token, resetPasswordDTO);
		return new ResponseEntity<String>(response.getMessage(), HttpStatus.OK);
	}

	@PostMapping("/forgotpassword")
	public ResponseEntity<String> forgotPassword(ForgotPasswordDTO forgotPasswordDTO) {
		Response response = service.forgotPassword(forgotPasswordDTO);
		return new ResponseEntity<String>(response.getMessage(), HttpStatus.OK);
	}
}
