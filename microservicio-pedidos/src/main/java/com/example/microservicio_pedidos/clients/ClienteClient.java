package com.example.microservicio_pedidos.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.microservicio_clientes.dto.ClienteDTO;
import com.example.microservicio_commons.models.entity.Clientes;

@FeignClient(name = "microservicio-clientes")
public interface ClienteClient {

    @GetMapping("/{id}")
    Clientes getClienteById(@PathVariable ClienteDTO clienteDTO);
}