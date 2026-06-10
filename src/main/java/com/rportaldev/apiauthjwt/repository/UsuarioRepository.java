package com.rportaldev.apiauthjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rportaldev.apiauthjwt.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	public Usuario findByCorreo(String correo);
	public boolean existsByCorreo(String correo);
}
