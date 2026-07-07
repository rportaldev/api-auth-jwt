package com.rportaldev.apiauthjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rportaldev.apiauthjwt.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findByCorreo(String correo);
	boolean existsByCorreo(String correo);
}
