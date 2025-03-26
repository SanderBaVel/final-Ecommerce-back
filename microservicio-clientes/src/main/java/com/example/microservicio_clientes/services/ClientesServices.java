package com.example.microservicio_clientes.services;

import java.util.List;
import java.util.Optional;

import com.example.microservicio_commons.models.entity.Clientes;
import com.example.microservicio_commons.services.CommonService;


public interface ClientesServices extends CommonService<Clientes>{

	Clientes actualizar(Clientes clientes, Long id);
	boolean validareEmail(String email);
	boolean validarTelefono(String Telefono);
}
