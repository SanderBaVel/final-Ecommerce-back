package com.example.microservicio_commons.models.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="PRODUCTOS")
public class Productos {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "PRODUCTOS_SEQ")
	@SequenceGenerator(name="PRODUCTOS_SEQ", sequenceName = "PRODUCTOS_SEQ", allocationSize=1 )
    @Column(name = "ID_PRODUCTO")
	private Long id;
	
	
	
	@Column(name = "NOMBRE")
	@NotBlank(message = "El nombre del producto es obligatoria")
	@Size(min = 1, max = 50, message ="El nombre del producto debe tener entre 1 y 50 caracteres ")
	private String nombre;
	
	
	@Column(name = "DESCRIPCION ")
	@NotBlank(message = "La descripcion es obligatoria")
	@Size(min = 1, max = 50, message ="La descripcion debe tener entre 1 y 50 caracteres ")
	private String descripcion;
	
	@Column(name = "PRECIO ")
	 @Min(value = 0, message = "El precio no puede ser negativo")
	@NotNull(message = "El precio  es obligatorio")
	private Long precio;
	
	@Column(name = "STOCK  ")
	 @Min(value = 0, message = "El precio no puede ser negativo")
  @NotNull(message = "El stock  es obligatorio")
	private Long stock;

	  @JsonIgnoreProperties("productos") // Para evitar recursión infinita
	    @ManyToMany(mappedBy = "productos") // Hace referencia al campo en Pedido
	    private List<Pedido> pedidos = new ArrayList<>();
	  
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getPrecio() {
		return precio;
	}

	public void setPrecio(Long precio) {
		this.precio = precio;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	
	
	
}
