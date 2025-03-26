package com.example.microservicio_commons.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "CLIENTES")
public class Clientes {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENTES_SEQ")
	@SequenceGenerator(name = "CLIENTES_SEQ", sequenceName = "CLIENTES_SEQ", allocationSize = 1)
	@Column(name =  "ID_CLIENTE")
	private Long id_cliente;
	
	@Column(name= "NOMBRE")
	@NotBlank(message = "El nombre es obligatorio")
	@Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
	private String nombre;
	
	@Column(name= "APELLIDOS")
	@NotBlank(message = "El apellido es obligatorio")
	@Size(max = 100, message = "El apellido no puede superar los 100 caracteres")
	private String apellidos;
	
	@Column(name= "EMAIL", unique = true)
	@NotBlank(message = "El E-mail es obligatorio")
	@Email(message = "Debe ser un email válido")
	@Size(max = 100, message = "El E-mail no puede superar los 100 caracteres")
	private String email;
	
	@Column(name = "TELEFONO", length = 20)  // Longitud ajustada a estándares internacionales
	@NotBlank(message = "El número telefónico es obligatorio")
	@Size(min = 8, max = 20, message = "El número telefónico debe tener entre 8 y 20 caracteres")
	@Pattern(regexp = "^[+]?[0-9\\s]+$", message = "Solo se permiten números, espacios y el símbolo +") 
	private String telefono;
	
	@Column(name= "DIRECCION")
	@NotBlank(message = "La direccion es obligatorio")
	@Size(max = 100, message = "El apellido no puede superar los 100 caracteres")
	private String direccion;

	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
	
	

}
