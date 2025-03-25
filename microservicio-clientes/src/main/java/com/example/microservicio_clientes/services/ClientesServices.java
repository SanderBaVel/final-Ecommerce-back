package com.example.microservicio_clientes.services;

import java.util.List;
import java.util.Optional;

import com.example.microservicio_clientes.models.entities.Clientes;

public interface ClientesServices{

	List<Clientes> listar();
	Optional<Clientes> obtenerPorId(Long id);
	Clientes crear (Clientes entity);
	Optional<Clientes> eliminarPorId(Long id);
	Clientes actualizar(Clientes clientes, Long id);
}
