package com.example.microservicio_pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microservicio_commons.models.entity.Pedido;



public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}