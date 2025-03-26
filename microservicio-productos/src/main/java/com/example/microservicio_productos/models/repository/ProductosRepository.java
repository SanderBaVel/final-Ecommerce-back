package com.example.microservicio_productos.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microservicio_commons.models.entity.Productos;


public interface ProductosRepository extends JpaRepository<Productos, Long> {

}
