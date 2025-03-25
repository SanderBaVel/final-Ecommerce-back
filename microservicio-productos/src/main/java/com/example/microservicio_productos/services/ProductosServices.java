package com.example.microservicio_productos.services;

import java.util.List;
import java.util.Optional;

import com.example.microservicio_productos.models.entity.Productos;

public interface ProductosServices {
	
	List<Productos> listar();
	Optional<Productos> obtenerPorId(Long id);
	Productos crear (Productos entity);
	Optional<Productos> eliminarPorId(Long id );
	Productos actualizar(Productos productos, Long id );

}
