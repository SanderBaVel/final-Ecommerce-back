package com.example.microservicio_clientes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.microservicio_clientes.controller.ClientesController;
import com.example.microservicio_clientes.repositories.ClientesRepository;
import com.example.microservicio_commons.models.entity.Clientes;
import com.example.microservicio_commons.services.CommonServiceImpl;


@Service

public class ClientesServicesImpl extends CommonServiceImpl<Clientes, ClientesRepository>  implements ClientesServices{

	@Override
	@Transactional
	public Clientes actualizar(Clientes clientes, Long id) {
		// TODO Auto-generated method stub
		Optional <Clientes> optClientes = repository.findById(id);
		if (optClientes.isPresent()) {
			Clientes clientesDb = optClientes.get();
			clientesDb.setNombre(clientes.getNombre());
			clientesDb.setApellidos(clientes.getApellidos());
			clientesDb.setTelefono(clientes.getTelefono());
			clientesDb.setEmail(clientes.getEmail());
			clientesDb.setDireccion(clientes.getDireccion());
			repository.save(clientesDb);
			return clientesDb;
		}
		return null;
	}

	@Override
	public boolean validareEmail(String email) {
		return repository.existsByEmail(email);
	}

	@Override
	public boolean validarTelefono(String Telefono) {
	    return repository.existsByTelefono(Telefono);
	}
	

	
	

}
