package com.example.microservicio_clientes.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.microservicio_commons.models.entity.Pedido;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ClienteDTO {

	private Long id;
	private String nombre;
	
	private String apellidos;
	
		private String email;
	
		private String telefono;
	
		private String direccion;
	
	private List<Long> pedidos;
	
	
	public ClienteDTO() {
	}


	


	public ClienteDTO(Long id, String nombre, String apellidos, String email, String telefono, String direccion,
			List<Long> pedidos) {
		
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
		this.pedidos = pedidos;
	}





	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
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


	public List<Long> getPedidos() {
		return pedidos;
	}


	public void setPedidos(List<Long> pedidos) {
		this.pedidos = pedidos;
	}


	@Override
	public String toString() {
		return "ClienteDTO  nombre=" + nombre + ", apellidos=" + apellidos + ", email="
				+ email + ", telefono=" + telefono + ", direccion=" + direccion + ", pedidos=" + pedidos + "]";
	}
	
	
}
