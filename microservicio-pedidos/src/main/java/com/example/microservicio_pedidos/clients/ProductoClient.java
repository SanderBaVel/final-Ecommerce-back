package com.example.microservicio_pedidos.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.microservicio_commons.models.entity.Productos;

@FeignClient(name = "microservicio-productos")
public interface ProductoClient {

    @GetMapping("{id}")
    Productos getProductoById(@PathVariable Long id);
}