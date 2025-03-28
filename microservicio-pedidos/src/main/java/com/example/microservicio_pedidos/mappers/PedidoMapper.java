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
import com.example.microservicio_productos.dto.ProductosDto;

@Component
public class PedidoMapper {

	@Autowired
	ClienteClient clienteFeign;
	
	@Autowired
	ProductoClient productoClient;
	
	
	public Pedido dtotoEntity(PedidoDTO dto) {
	  
	    Clientes cliente = clienteFeign.getClienteById(dto.getCliente());
	    if (cliente == null) {
	        throw new RuntimeException("Cliente no encontrado con ID: " + dto.getCliente());
	    }

	    // Verificar si los productos existen
	    List<Productos> productos = obtenerProductos(dto.getProductosIds());
	    if (productos.isEmpty()) {
	        throw new RuntimeException("Productos no encontrados para los IDs: " + dto.getProductosIds());
	    }

	    Pedido pedido = new Pedido();
	    pedido.setCliente(cliente);
	    pedido.setEstado(dto.getEstado());
	    pedido.setProductos(productos);

	    return pedido;
	}

    private List<Productos> obtenerProductos(List<ProductosDto> list) {
        List<Productos> productos = new ArrayList<>();
        for (ProductosDto productoId : list) {
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

