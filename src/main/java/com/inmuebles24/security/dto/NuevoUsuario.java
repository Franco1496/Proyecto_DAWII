package com.inmuebles24.security.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Data
public class NuevoUsuario {
    @NotBlank(message = "campo requerido, ingresar nombre")
    private String nombre;
    @NotBlank(message = "campo requerido, ingresar apellido")
    private String apellido;
    @NotBlank(message = "campo requerido, ingresar telefono")
    private String telefono;
    @NotBlank(message = "campo requerido, ingresar nombre usuario")
    private String nombreUsuario;
    @Email(message = "campo requerido, ingresar email")
    private String email;
    @NotBlank(message = "campo requerido, ingresar password")
    private String password;
    private Set<String> roles = new HashSet<>();
}