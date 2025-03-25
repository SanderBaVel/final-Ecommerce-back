package com.example.microservicio_clientes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.microservicio_clientes.controller.ClientesController;
import com.example.microservicio_clientes.models.entities.Clientes;
import com.example.microservicio_clientes.repositories.ClientesRepository;


@Service
public class ClientesServicesImpl implements ClientesServices{
	
	@Autowired
	protected ClientesRepository clientesRepository;

	@Override
	public List<Clientes> listar() {
		return clientesRepository.findAll();
}

	@Override
	public Optional<Clientes> obtenerPorId(Long id) {
		return clientesRepository.findById(id);
	}

	@Override
	public Clientes crear(Clientes entity) {
		return clientesRepository.save(entity);
	}

	@Override
	@Transactional
	public Optional<Clientes> eliminarPorId(Long id) {
		Optional<Clientes> entity = clientesRepository.findById(id);
		if (entity.isPresent()) {
			clientesRepository.deleteById(id);
			return entity;
		}
		return Optional.empty();
	}

	@Override
	public Clientes actualizar(Clientes clientes, Long id) {
		// TODO Auto-generated method stub
		Optional <Clientes> optClientes = clientesRepository.findById(id);
		if (optClientes.isPresent()) {
			Clientes clientesDb = optClientes.get();
			clientesDb.setNombre(clientes.getNombre());
			clientesDb.setApellidos(clientes.getApellidos());
			clientesDb.setTelefono(clientes.getTelefono());
			clientesDb.setEmail(clientes.getEmail());
			clientesDb.setDireccion(clientes.getDireccion());
			clientesRepository.save(clientesDb);
			return clientesDb;
		}
		return null;
	}

	@Override
	public boolean validareEmail(String email) {
		return clientesRepository.existsByEmail(email);
	}

	@Override
	public boolean validarTelefono(String Telefono) {
	    return clientesRepository.existsByTelefono(Telefono);
	}
	

	
	

}
