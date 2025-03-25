package com.example.microservicio_productos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.microservicio_productos.services.ProductosServices;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
	@Autowired
	protected ProductosServices services;

	@GetMapping 
	public ResponseEntity<List> getAll(){
		return ResponseEntity.ok(services.listar());
		
		
	}
	
	
} 
