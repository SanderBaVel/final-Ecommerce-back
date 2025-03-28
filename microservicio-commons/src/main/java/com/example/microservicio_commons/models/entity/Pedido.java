package com.example.microservicio_commons.models.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "pedidos")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedidos_seq")
	@SequenceGenerator(name = "pedidos_seq", sequenceName = "pedidos_seq", allocationSize = 1)
    private Long id;
    
    @JsonBackReference
	@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE")	
	@NotNull(message = "El cliente es obligatorio")
    private Clientes cliente;
    
    @ManyToMany
    @JoinTable(
        name = "pedido_producto",
        joinColumns = @JoinColumn(name = "pedido_id"),
        inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    //private List<Productos> productos = new ArrayList<>();
    private List<Productos> productos;
    @Column(nullable = false, precision = 10, scale = 2)
    private Long total;
    
    @Column(nullable = false)
    private LocalDateTime fechaCreacion;
    

    @Column(nullable = false)
    private String estado;
    
    @PrePersist
    public void prePersist() {
        this.fechaCreacion = LocalDateTime.now();
        calcularTotal();
    }
    
    public void calcularTotal() {
        this.total = productos.stream()
            .map(Productos::getPrecio)    
            .filter(Objects::nonNull)      
            .reduce(0L, Long::sum);
    }
    
    
	public Pedido() {
		this.productos = new ArrayList<>();
	}

public Pedido(Long id, @NotNull(message = "El cliente es obligatorio") Clientes cliente, List<Productos> productos,
		Long total, LocalDateTime fechaCreacion, String estado) {
	this.id = id;
	this.cliente = cliente;
	this.productos = new ArrayList<>();
	this.total = total;
	this.fechaCreacion = fechaCreacion;
	this.estado = estado;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Clientes getCliente() {
	return cliente;
}

public void setCliente(Clientes cliente) {
	this.cliente = cliente;
}

public List<Productos> getProductos() {
	return productos;
}



public void setProductos(List<Productos> productos) {
	this.productos = productos;
}

public Long getTotal() {
	return total;
}

public void setTotal(Long total) {
	this.total = total;
}

public LocalDateTime getFechaCreacion() {
	return fechaCreacion;
}

public void setFechaCreacion(LocalDateTime fechaCreacion) {
	this.fechaCreacion = fechaCreacion;
}

public String getEstado() {
	return estado;
}

public void setEstado(String estado) {
	this.estado = estado;
}




}