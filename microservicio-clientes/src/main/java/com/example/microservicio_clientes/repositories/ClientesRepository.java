package com.example.microservicio_clientes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microservicio_clientes.models.entities.Clientes;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {

}
