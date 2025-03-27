package com.example.microservicio_clientes.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.microservicio_commons.models.entity.Pedido;


@FeignClient(name = "microservicio-clientes")
public interface PedidosClient {
	
	@GetMapping("/{id}")
	Pedido getPedidosById(@PathVariable Long id);
}
