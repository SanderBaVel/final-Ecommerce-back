package com.example.microservicio_pedidos.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.microservicio_commons.models.entity.Productos;

public class PedidoDTO {

	private Long idCliente;
	private List<Long> productosIds;
	private Long estado;
	
	
	public PedidoDTO() {
		this.productosIds = new ArrayList<>();
	}
	
	public PedidoDTO(Long idCliente,  Long estado) {
		this.idCliente = idCliente;
		this.productosIds = new ArrayList<>();
		this.estado = estado;
	}
	
	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public List<Long> getProductosIds() {
		return productosIds;
	}

	public void setProductosIds(List<Long> productosIds) {
		this.productosIds = productosIds;
	}

	public Long getEstado() {
		return estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "PedidoDTO [idCliente=" + idCliente + ", productosIds=" + productosIds + ", estado=" + estado + "]";
	}
	
	
}
