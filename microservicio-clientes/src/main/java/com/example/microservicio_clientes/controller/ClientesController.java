package com.example.microservicio_clientes.controller;

import java.util.Collections;
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
import com.example.microservicio_clientes.models.entities.Clientes;
import com.example.microservicio_clientes.services.ClientesServices;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/clientes")
public class ClientesController {
	   @Autowired
	    protected ClientesServices service;
	   
	    
	    @GetMapping
	    public ResponseEntity<List> getAll(){
	        return ResponseEntity.ok(service.listar());
	    }
	    
	    @GetMapping("/{id}")
	    public ResponseEntity<Clientes> getById(@PathVariable Long id){
	        Optional<Clientes> entity = service.obtenerPorId(id);
	        if(entity.isPresent()) {
	            return ResponseEntity.ok(entity.get());
	        }
	        return ResponseEntity.notFound().build();
	    }

	    @PostMapping
	    public ResponseEntity<?> create(@Valid @RequestBody Clientes clientes, BindingResult result) {
	        if (result.hasErrors()) {
	            return this.validar(result);
	        }

	        
	        if (service.validareEmail(clientes.getEmail())) {
	            return ResponseEntity.badRequest().body(Collections.singletonMap("error", "Email Ya existe"));
	        }

	        if (service.validarTelefono(clientes.getTelefono())) {
	            return ResponseEntity.badRequest().body(Collections.singletonMap("error", "Telefono ya existe"));
	        }
	        
	        
	        Clientes entityDb = service.crear(clientes);
	        return ResponseEntity.status(HttpStatus.CREATED).body(entityDb);
	    }
	    
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Clientes> delete(@PathVariable Long id){
	    	Optional <Clientes> entity = service.eliminarPorId(id);
	    	if (entity.isPresent()) {
	    		return ResponseEntity.ok().body(entity.get());
	    	}
	    	return ResponseEntity.notFound().build();
			
	    }
	    
		@PutMapping("/{id}")
		public ResponseEntity<?> actualizar(@Valid @RequestBody Clientes clientes,
				BindingResult result, @PathVariable Long id){
			if(result.hasErrors()) {
				return this.validar(result);
			}
			
	        if (result.hasErrors()) {
	            return this.validar(result);
	        }

	        
	        if (service.validareEmail(clientes.getEmail())) {
	            return ResponseEntity.badRequest().body(Collections.singletonMap("error", "Email Ya existe"));
	        }

	        if (service.validarTelefono(clientes.getTelefono())) {
	            return ResponseEntity.badRequest().body(Collections.singletonMap("error", "Telefono ya existe"));
	        }
	        
	        
			Clientes clientesDb = service.actualizar(clientes, id);
			if(clientesDb != null) {
				return ResponseEntity.status(HttpStatus.CREATED).body(clientesDb);
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
