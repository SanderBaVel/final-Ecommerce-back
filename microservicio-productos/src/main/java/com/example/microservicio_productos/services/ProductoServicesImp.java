package com.example.microservicio_productos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.microservicio_commons.models.entity.Productos;
import com.example.microservicio_commons.services.CommonServiceImpl;
import com.example.microservicio_productos.controllers.ProductoController;
import com.example.microservicio_productos.models.repository.ProductosRepository;

@Service
public class ProductoServicesImp extends CommonServiceImpl<Productos, ProductosRepository> implements ProductosServices {

	@Override
	@Transactional
	public Productos actualizar(Productos productos, Long id) {
		Optional<Productos> productoss = repository.findById(id);
		if(productoss.isPresent()) {
			Productos productosDb = productoss.get();
			productosDb.setNombre(productos.getNombre());
			productosDb.setDescripcion(productos.getDescripcion());
			productosDb.setPrecio(productos.getPrecio());
			productosDb.setStock(productos.getStock());
			
			return repository.save(productosDb);
		}
		
		
	
		return null;
	}

}
