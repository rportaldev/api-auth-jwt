package com.rportaldev.apiauthjwt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rportaldev.apiauthjwt.dto.AuthResponseDTO;
import com.rportaldev.apiauthjwt.dto.LoginDTO;
import com.rportaldev.apiauthjwt.dto.RegisterDTO;
import com.rportaldev.apiauthjwt.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final AuthService authService;

	@PostMapping("/register")
	public ResponseEntity<AuthResponseDTO> registrar(@RequestBody @Valid RegisterDTO dto) {

		AuthResponseDTO response = authService.registrar(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PostMapping("/login")
	public ResponseEntity<AuthResponseDTO> login(@RequestBody @Valid LoginDTO dto) {

		AuthResponseDTO response = authService.login(dto);
		return ResponseEntity.ok(response);
	}
	
}
