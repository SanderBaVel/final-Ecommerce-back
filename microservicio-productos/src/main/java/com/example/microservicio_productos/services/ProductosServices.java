package com.example.microservicio_productos.services;

import java.util.List;
import java.util.Optional;

import com.example.microservicio_commons.models.entity.Productos;
import com.example.microservicio_commons.services.CommonService;

public interface ProductosServices extends CommonService<Productos>{
	
	Productos actualizar(Productos productos, Long id );

}
