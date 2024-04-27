package com.ejercicio.java.services;

import java.util.List;

import com.ejercicio.java.models.Cliente;

public interface ClienteService {
	List<Cliente> obtenerClientes();
	Cliente obtenerClienteByIdentificacion(String identificacion);
	Cliente guardarCliente(Cliente cliente);
}
