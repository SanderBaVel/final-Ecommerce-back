package com.example.microservicio_pedidos.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservicio_clientes.dto.ClienteDTO;
import com.example.microservicio_commons.models.entity.Clientes;
import com.example.microservicio_commons.models.entity.Pedido;
import com.example.microservicio_commons.models.entity.Productos;
import com.example.microservicio_commons.services.CommonServiceImpl;
import com.example.microservicio_pedidos.clients.ClienteClient;
import com.example.microservicio_pedidos.clients.ProductoClient;
import com.example.microservicio_pedidos.dto.PedidoDTO;
import com.example.microservicio_pedidos.dto.PedidoEditarDTO;
import com.example.microservicio_pedidos.mappers.PedidoMapper;
import com.example.microservicio_pedidos.models.enums.EstadoPedido;
import com.example.microservicio_pedidos.repository.PedidoRepository;
import com.example.microservicio_productos.dto.ProductosDto;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class PedidoServiceImpl extends CommonServiceImpl<Pedido, PedidoRepository> implements PedidoService{


	@Autowired
	private PedidoMapper pedidoMapper;

	@Autowired
	private PedidoRepository pedidoRepository;
	
	
	@Transactional
	public Pedido agregarPedido(PedidoDTO pedidoDTO) {
		return repository.save(pedidoMapper.dtotoEntity(pedidoDTO));
		
	}
	
	@Transactional
	public Pedido editarPedido(Long id, PedidoEditarDTO dto) {
		
		 Pedido pedido = repository.findById(id).orElseThrow(EntityNotFoundException::new);
		    
		    if (dto.getEstado() != null && !dto.getEstado().isEmpty()) {
		        pedido.setEstado(dto.getEstado());
		    }

		    return repository.save(pedido);
	}

//	@Override
//	@Transactional
//    public Pedido updateEstado(Long id, EstadoPedido estado) {
//        Pedido pedido = repository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Pedido no encontrado"));
//        
//        //pedido.setEstado(estado);
//        return repository.save(null);
	@Override
	public Pedido updateEstado(Long id, EstadoPedido estado) {
		
		return null;
	}
	
	
	public List<PedidoDTO> obtenerPedidosConClientesYProductos() {
	    List<Pedido> pedidos = pedidoRepository.findAll();
	    
	    return pedidos.stream().map(pedido -> {
	        PedidoDTO dto = new PedidoDTO();
	        dto.setId(pedido.getId());

	        // Cliente
	        if (pedido.getCliente() != null) {
	            ClienteDTO clienteDTO = new ClienteDTO();
	            clienteDTO.setId(pedido.getCliente().getId_cliente());
	            clienteDTO.setNombre(pedido.getCliente().getNombre());
	            clienteDTO.setApellidos(pedido.getCliente().getApellidos());
	            clienteDTO.setDireccion(pedido.getCliente().getDireccion());
	            clienteDTO.setTelefono(pedido.getCliente().getTelefono());
	            
	            dto.setCliente(clienteDTO);
	        }

	     
	        List<ProductosDto> productosDTO = pedido.getProductos().stream()
	                .map(prod -> {
	                    ProductosDto productoDTO = new ProductosDto();
	                    productoDTO.setId(prod.getId());
	                    productoDTO.setNombre(prod.getNombre());
	                    productoDTO.setDescripcion(prod.getDescripcion());
	                    productoDTO.setPrecio(prod.getPrecio());
	                    return productoDTO;
	                })
	                .collect(Collectors.toList());

	            dto.setProductosIds(productosDTO) ;
	            dto.setEstado(pedido.getEstado());

	            return dto;
	        }).collect(Collectors.toList());
	}
}

