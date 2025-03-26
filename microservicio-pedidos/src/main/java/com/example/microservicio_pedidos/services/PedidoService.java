package com.example.microservicio_pedidos.services;

import java.util.List;
import java.util.Optional;

import com.example.microservicio_commons.models.entity.Pedido;
import com.example.microservicio_commons.services.CommonService;
import com.example.microservicio_pedidos.models.enums.EstadoPedido;

public interface PedidoService extends CommonService<Pedido>{

	public Pedido updateEstado(Long id, EstadoPedido estado);
	
}
