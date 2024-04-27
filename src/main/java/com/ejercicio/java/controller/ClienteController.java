package com.ejercicio.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.java.models.Cliente;
import com.ejercicio.java.services.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	/*@GetMapping
	public ResponseEntity<?> Obtener()
	{
		List<Cliente> clientes = clienteService.obtenerClientes();
		if(clientes == null || clientes.isEmpty())
		{
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(clientes);
	}*/
	
	//@GetMapping("/{identificacion}")
	@GetMapping
	public ResponseEntity<?> ObtenerByIdentificacion(@RequestBody Cliente cliente)
	{
		Cliente clientes = clienteService.obtenerClienteByIdentificacion(cliente.getIdentificacion());
		if(clientes == null)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El cliente ingresado no existe");
		}
		String encoded = java.util.Base64.getEncoder()
                .encodeToString(clientes.getIdentificacion().getBytes());
		
		clientes.setIdentificacion(encoded);
		
		return ResponseEntity.status(HttpStatus.OK).body(clientes);
	}
	
	@PostMapping()
	public ResponseEntity<?> guardar(@RequestBody @Validated Cliente cliente, BindingResult result) {
		if(result.hasErrors())
		{
			return ResponseEntity.ok("El cliente no existe");
		}
		Cliente newCliente = clienteService.guardarCliente(cliente);
		if(newCliente == null)
			throw new DataIntegrityViolationException("Error el cliente no existe "); 
			//return ResponseEntity.status(HttpStatus.CONFLICT).body("Ya existe un cliente");
		return ResponseEntity.status(HttpStatus.CREATED).body(newCliente);
	}
	
}
