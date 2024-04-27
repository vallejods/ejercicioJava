package com.ejercicio.java.models;

import java.util.Collection;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente {
	
	public Cliente() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	private String nombres;
	private String apellidos;
	private String direccion;

	// @Email (message = "Favor ingrese un email válido")
	private String email;
	private String telefono;
	private String identificacion;

	// Persistir, eliminar en Cascada
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Cuenta> detalleCuentaList;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public List<Cuenta> getDetalleCuentaList() {
		return detalleCuentaList;
	}

	public void setDetalleCuentaList(List<Cuenta> detalleCuentaList) {
		this.detalleCuentaList = detalleCuentaList;
	}

	

	
}
