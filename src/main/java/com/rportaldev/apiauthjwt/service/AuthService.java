package com.rportaldev.apiauthjwt.service;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rportaldev.apiauthjwt.entity.Usuario;
import com.rportaldev.apiauthjwt.enums.Rol;
import com.rportaldev.apiauthjwt.exception.CorreoYaExisteException;
import com.rportaldev.apiauthjwt.exception.RecursoNoEncontradoException;
import com.rportaldev.apiauthjwt.repository.UsuarioRepository;
import com.rportaldev.apiauthjwt.security.JwtService;
import com.rportaldev.apiauthjwt.dto.AuthResponseDTO;
import com.rportaldev.apiauthjwt.dto.LoginDTO;
import com.rportaldev.apiauthjwt.dto.RegisterDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final UsuarioRepository usuarioRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	private final JwtService jwtService;
	
	private final AuthenticationManager authenticationManager;
	
	
	//METODOS
	public AuthResponseDTO registrar(RegisterDTO dto) {

		if (usuarioRepository.existsByCorreo(dto.getCorreo())) {
			throw new CorreoYaExisteException("El correo ya está registrado: " + dto.getCorreo());
		}

		Usuario usuario = new Usuario();
		usuario.setNombre(dto.getNombre());
		usuario.setCorreo(dto.getCorreo());
		usuario.setPassword(passwordEncoder.encode(dto.getPassword()));
		usuario.setRol(Rol.ROLE_USER);

		usuarioRepository.save(usuario);

		String token = jwtService.generarToken(usuario);

		return new AuthResponseDTO(
				token,
				"Bearer",
				usuario.getCorreo(),
				usuario.getRol().name());
	}
	
	
	public AuthResponseDTO login(LoginDTO dto) {

		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						dto.getCorreo(),
						dto.getPassword()));

		Usuario usuario = usuarioRepository.findByCorreo(dto.getCorreo())
				.orElseThrow(() -> new RecursoNoEncontradoException(
						"Usuario no encontrado con correo: " + dto.getCorreo()));

		String token = jwtService.generarToken(usuario);

		return new AuthResponseDTO(
				token,
				"Bearer",
				usuario.getCorreo(),
				usuario.getRol().name());
	}
}
