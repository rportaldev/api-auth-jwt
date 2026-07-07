package com.rportaldev.apiauthjwt.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class LoginDTO {

	@NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo no es válido")
	private String correo;
	
	@NotBlank(message = "El password es obligatorio")
	private String password;
}
