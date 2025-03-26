package com.example.microservicio_pedidos.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.microservicio_commons.models.entity.Clientes;
import com.example.microservicio_commons.models.entity.Pedido;
import com.example.microservicio_commons.models.entity.Productos;
import com.example.microservicio_pedidos.clients.ClienteClient;
import com.example.microservicio_pedidos.clients.ProductoClient;
import com.example.microservicio_pedidos.dto.PedidoDTO;

@Component
public class PedidoMapper {

	@Autowired
	ClienteClient clienteFeign;
	
	@Autowired
	ProductoClient productoClient;
	
	
	public Pedido dtotoEntity(PedidoDTO dto) {
		if(dto == null) {
			return null;
		}
		
		
		Optional<Clientes> optClinte = Optional.of(clienteFeign.getClienteById(dto.getIdCliente()));
		if(optClinte.isEmpty()) {
			return null;
		}
		if(dto.getProductosIds().isEmpty()) {
			throw new RuntimeException("Cliente no encontrado con ID: " + dto.getIdCliente());
			}
		System.out.println(dto);
		Pedido pedido = new Pedido();
		pedido.setCliente(optClinte.get());
		pedido.setEstado(dto.getEstado());
		
		
        List<Productos> productos = obtenerProductos(dto.getProductosIds());
        pedido.setProductos(productos);
		return pedido;
		
	}
		
	  private List<Productos> obtenerProductos(List<Long> productosIds) {
	        List<Productos> productos = new ArrayList<>();
	        
	        for (Long productoId : productosIds) {
	            Productos producto = productoClient.getProductoById(productoId);
	            if (producto != null) {
	                productos.add(producto);
	            } else {
	                throw new RuntimeException("Producto no encontrado con ID: " + productoId);
	            }
	        }
	        
	        return productos;
	    }
	}

