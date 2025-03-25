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

import com.example.microservicio_productos.models.entity.Productos;
import com.example.microservicio_productos.services.ProductosServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
	@Autowired
	protected ProductosServices services;

	@GetMapping 
	public ResponseEntity<List> getAll(){
		return ResponseEntity.ok(services.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Productos> getById(@PathVariable Long id){
		Optional<Productos> entity = services.obtenerPorId(id);
		if(entity.isPresent()) {
			return ResponseEntity.ok(entity.get());
			
		}
		return ResponseEntity.notFound().build();
		
	}
	
	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody Productos entity, BindingResult result){
		
		 if (result.hasErrors()) {
	            return this.validar(result);
	        }
	        Productos entityDb = services.crear(entity);
	        return ResponseEntity.status(HttpStatus.CREATED).body(entityDb);
		
	}
	
	
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Productos> delete(@PathVariable Long id){
	    	Optional <Productos> entity = services.eliminarPorId(id);
	    	if (entity.isPresent()) {
	    		return ResponseEntity.ok().body(entity.get());
	    	}
	    	return ResponseEntity.notFound().build();
			
	    }
	
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
	
	 protected ResponseEntity<?> validar(BindingResult result) {
	        Map<String, Object> errores = new HashMap<>();
	        result.getFieldErrors().forEach(err -> {
	            errores.put(err.getField(), err.getDefaultMessage());
	        });
	        return ResponseEntity.badRequest().body(errores);
	    }
	
	
	
} 
