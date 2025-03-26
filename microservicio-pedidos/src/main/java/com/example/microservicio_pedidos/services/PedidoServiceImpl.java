package com.example.microservicio_pedidos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservicio_commons.models.entity.Pedido;
import com.example.microservicio_commons.services.CommonServiceImpl;
import com.example.microservicio_pedidos.clients.ClienteClient;
import com.example.microservicio_pedidos.clients.ProductoClient;
import com.example.microservicio_pedidos.dto.PedidoDTO;
import com.example.microservicio_pedidos.mappers.PedidoMapper;
import com.example.microservicio_pedidos.models.enums.EstadoPedido;
import com.example.microservicio_pedidos.repository.PedidoRepository;

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

	@Override
	@Transactional
    public Pedido updateEstado(Long id, EstadoPedido estado) {
        Pedido pedido = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido no encontrado"));
        
        //pedido.setEstado(estado);
        return repository.save(pedido);
    }

}
