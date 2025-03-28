package com.example.microservicio_pedidos.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.microservicio_clientes.dto.ClienteDTO;
import com.example.microservicio_commons.models.entity.Productos;
import com.example.microservicio_productos.dto.ProductosDto;

public class PedidoDTO {
	private Long id;
	private ClienteDTO  cliente;
	private List<ProductosDto> productosIds;
	private String estado;
	
	
	public PedidoDTO() {
		this.productosIds = new ArrayList<>();
	}
	
	
	
	
	




	public PedidoDTO(Long id, ClienteDTO cliente, List<ProductosDto> productosIds, String estado) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.productosIds = productosIds;
		this.estado = estado;
	}









	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	



	public ClienteDTO getCliente() {
		return cliente;
	}









	public void setCliente(ClienteDTO clienteDTO) {
		this.cliente = clienteDTO;
	}









	public List<ProductosDto> getProductosIds() {
		return productosIds;
	}

	public void setProductosIds(List<ProductosDto> productosDTO) {
		this.productosIds = productosDTO;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "PedidoDTO [idCliente=" + cliente + ", productosIds=" + productosIds + ", estado=" + estado + "]";
	}
	
	
}
