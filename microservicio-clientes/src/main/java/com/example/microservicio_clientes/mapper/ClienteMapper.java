package com.example.microservicio_clientes.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.microservicio_clientes.clients.PedidosClient;
import com.example.microservicio_clientes.dto.ClienteDTO;
import com.example.microservicio_commons.models.entity.Clientes;
import com.example.microservicio_commons.models.entity.Pedido;
import com.example.microservicio_commons.models.entity.Productos;

@Component
public class ClienteMapper {

	@Autowired
	PedidosClient pedidosClient;
	
	public Clientes dtoToEntity(ClienteDTO dto){
		if(dto==null) {
		return null;
	}
	

	Clientes cliente = new Clientes();
	cliente.setNombre(dto.getNombre());
	cliente.setApellidos(dto.getApellidos());
	cliente.setDireccion(dto.getDireccion());
	cliente.setEmail(dto.getEmail());
	cliente.setTelefono(dto.getTelefono());
	
	List<Pedido> pedidos = obtenerProductos(dto.getPedidos());
	cliente.setPedidos(pedidos);
	return cliente;
	
	}
	
	public List<Pedido> obtenerProductos(List<Long> pedidos){
		List<Pedido> pedidosList = new ArrayList<>();
		
		for (Long pedidoID : pedidos) {
            Pedido pedido = pedidosClient.getPedidosById(pedidoID);
            if (pedido != null) {
            	pedidosList.add(pedido);
            } else {
                throw new RuntimeException("Producto no encontrado: ");
            }
        }
        
        return pedidosList;
    }
	
	
}
