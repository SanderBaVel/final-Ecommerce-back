package com.example.microservicio_pedidos.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservicio_commons.controller.CommonController;
import com.example.microservicio_commons.models.entity.Pedido;
import com.example.microservicio_pedidos.dto.PedidoDTO;
import com.example.microservicio_pedidos.mappers.PedidoMapper;
import com.example.microservicio_pedidos.models.enums.EstadoPedido;
import com.example.microservicio_pedidos.services.PedidoService;
import com.example.microservicio_pedidos.services.PedidoServiceImpl;

import jakarta.validation.Valid;

@RestController
public class PedidoController extends CommonController<Pedido, PedidoService>{

	@Autowired
	private PedidoServiceImpl pedidoService;
	
	@Autowired
	private PedidoMapper mapper;
	
	@PostMapping("/agregar")
   public ResponseEntity<Pedido> agregaPEdido(@RequestBody PedidoDTO pedidoDto){
	   return ResponseEntity.ok(pedidoService.agregarPedido(pedidoDto));
	   
   }

	

}