package com.example.microservicio_clientes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microservicio_commons.models.entity.Clientes;


public interface ClientesRepository extends JpaRepository<Clientes, Long> {

	boolean existsByEmail(String email);
	boolean existsByTelefono(String telefono);
}
