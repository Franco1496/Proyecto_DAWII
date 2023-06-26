package com.inmuebles24.security.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "campo requerido, ingresar nombre")
    @Pattern(regexp = "^(?! )([A-Z][a-zA-ZñÑáéíóúÁÉÍÓÚ']{1,9})( [A-Z][a-zA-ZñÑáéíóúÁÉÍÓÚ]{1,9}){0,2}$")
    private String nombre;
    @NotBlank(message = "campo requerido, ingresar apellido")
    @Pattern(regexp = "^(?! )([A-Z][a-zA-ZñÑáéíóúÁÉÍÓÚ']{1,9})( [A-Z][a-zA-ZñÑáéíóúÁÉÍÓÚ]{1,9}){0,2}$")
    private String apellido;
    @NotBlank(message = "campo requerido, ingresar telefono")
    @Pattern(regexp = "^(?! )(?!.*(\\d)\\1{4})(9[0-9]{8}|01[2-7][0-9]{6})")
    private String telefono;
    @NotBlank(message = "campo requerido, ingresar nombre usuario")
    private String nombreUsuario;
    @Email(message = "campo requerido, ingresar email")
    @Pattern(regexp = "^(?! )[a-z0-9._-]+@[a-z0-9.-]+\\.[a-z]{2,4}$", message = "email invalido")
    private String email;
    @NotBlank(message = "campo requerido, ingresar password")
    private String password;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
    private Date fechaCreacion;
    @Column(columnDefinition = "boolean default true")
    private boolean flagEstado;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();

    @PrePersist
    public void prePersist() {
        fechaCreacion = new Date();
        flagEstado = true;
    }
    public Usuario() {
    }

    public Usuario(@NotBlank String nombre,@NotBlank String apellido,@NotBlank String telefono,@NotBlank String nombreUsuario,@NotBlank @Email String email,@NotBlank String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
    }
}