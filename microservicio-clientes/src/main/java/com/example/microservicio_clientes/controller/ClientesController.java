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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.microservicio_clientes.services.ClientesServices;
import com.example.microservicio_commons.controller.CommonController;
import com.example.microservicio_commons.models.entity.Clientes;

import jakarta.validation.Valid;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/clientes")
public class ClientesController extends CommonController<Clientes, ClientesServices>{
	   @Autowired
	    protected ClientesServices service;
	    
	
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
		
	  
	   
}
