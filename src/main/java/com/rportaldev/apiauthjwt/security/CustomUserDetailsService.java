package com.rportaldev.apiauthjwt.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rportaldev.apiauthjwt.entity.Usuario;
import com.rportaldev.apiauthjwt.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{

	private final UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioRepository.findByCorreo(username);
		
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		return User.builder()
		        .username(usuario.getCorreo())
		        .password(usuario.getPassword())
		        .authorities(usuario.getRol().name())
		        .build();
	}
}
