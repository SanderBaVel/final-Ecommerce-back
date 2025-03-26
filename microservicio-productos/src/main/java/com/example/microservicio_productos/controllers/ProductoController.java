package com.example.microservicio_productos.controllers;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservicio_commons.controller.CommonController;
import com.example.microservicio_commons.models.entity.Productos;
import com.example.microservicio_productos.services.ProductosServices;

import jakarta.validation.Valid;

@RestController
public class ProductoController extends CommonController<Productos, ProductosServices>{
	@Autowired
	protected ProductosServices services;


	  @PutMapping("/{id}")
	    public ResponseEntity<?> actualizar(@Valid @RequestBody Productos producto,
	                                        BindingResult result, @PathVariable Long id) {
			if(result.hasErrors()) {
				return this.validar(result);
			}
			Productos productosDb = services.actualizar(producto, id);
			if(productosDb != null) {
				return ResponseEntity.status(HttpStatus.CREATED).body(productosDb);
			}
			return ResponseEntity.notFound().build();
		}
	
} 
