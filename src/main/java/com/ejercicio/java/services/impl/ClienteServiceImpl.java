package com.ejercicio.java.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.java.models.Cliente;
import com.ejercicio.java.models.Cuenta;
import com.ejercicio.java.repositories.ClienteRepository;
import com.ejercicio.java.services.ClienteService;

@Service
public class ClienteServiceImpl  implements ClienteService{

	@Autowired
	ClienteRepository clienteRepository;
	
	
	@Override
	public List<Cliente> obtenerClientes() {
		
		return clienteRepository.findAll();
	}

	@Override
	public Cliente guardarCliente(Cliente cliente) {

		for(Cuenta detalle : cliente.getDetalleCuentaList())
		{
			
			detalle.setCliente(cliente);
		}
		return clienteRepository.save(cliente);
	}

	@Override
	public Cliente obtenerClienteByIdentificacion(String identificacion) {
		// TODO Auto-generated method stub
		return clienteRepository.findByIdentificacion(identificacion);
	}

	
}
