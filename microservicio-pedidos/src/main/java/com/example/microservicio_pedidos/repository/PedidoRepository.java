package com.example.microservicio_pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microservicio_commons.models.entity.Pedido;
import com.example.microservicio_pedidos.dto.PedidoDTO;



public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	Pedido save(PedidoDTO dtotoEntity);
}