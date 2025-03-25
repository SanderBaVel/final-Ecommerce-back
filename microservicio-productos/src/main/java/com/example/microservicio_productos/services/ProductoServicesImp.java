package com.example.microservicio_productos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservicio_productos.models.entity.Productos;
import com.example.microservicio_productos.models.repository.ProductosRepository;

@Service
public class ProductoServicesImp implements ProductosServices {

	@Autowired
	protected ProductosRepository produRepository;
	
	@Override
	public List<Productos> listar() {
		// TODO Auto-generated method stub
		return produRepository.findAll();
	}

	@Override
	public Optional<Productos> obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Productos crear(Productos entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Productos> eliminarPorId(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Productos actualizar(Productos productos, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
