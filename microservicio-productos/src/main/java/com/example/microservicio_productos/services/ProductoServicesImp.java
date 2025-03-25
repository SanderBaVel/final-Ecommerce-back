package com.example.microservicio_productos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.microservicio_productos.controllers.ProductoController;
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
	
		return produRepository.findById(id);
	}

	@Override
	public Productos crear(Productos entity) {
		
		return produRepository.save(entity);
	}

	@Override
	@Transactional
	public Optional<Productos> eliminarPorId(Long id) {
		Optional<Productos> entity = produRepository.findById(id);
		if(entity.isPresent()) {
			produRepository.deleteById(id);
			return entity;
			
		}
		return Optional.empty();
	}

	@Override
	public Productos actualizar(Productos productos, Long id) {
		Optional<Productos> productoss = produRepository.findById(id);
		if(productoss.isPresent()) {
			Productos productosDb = productoss.get();
			productosDb.setNombre(productos.getNombre());
			productosDb.setDescripcion(productos.getDescripcion());
			productosDb.setPrecio(productos.getPrecio());
			productosDb.setStock(productos.getStock());
			
			return produRepository.save(productosDb);
		}
		
		
	
		return null;
	}

}
