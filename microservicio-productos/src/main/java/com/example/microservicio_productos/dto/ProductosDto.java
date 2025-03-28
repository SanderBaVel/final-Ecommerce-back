package com.example.microservicio_productos.dto;

public class ProductosDto {
	   private Long id;
	    private String nombre;
	    private String descripcion;
	    private Long precio;
	    private Long stock;
	    
	    
	    
		public ProductosDto() {
			
		}
		public ProductosDto(Long id, String nombre, String descripcion, Long precio, Long stock) {
			
			this.id = id;
			this.nombre = nombre;
			this.descripcion = descripcion;
			this.precio = precio;
			this.stock = stock;
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
