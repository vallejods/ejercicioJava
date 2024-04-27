package com.ejercicio.java.models;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cuenta {
	
	public Cuenta() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private String numerocuenta;
	private String descripcion;
	private String tipocuenta;
	private BigDecimal saldo;
	private Long estado;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	@JsonIgnore
	private Cliente cliente;//Campo Maapeado desde el Maestro

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNumerocuenta() {
		return numerocuenta;
	}

	public void setNumerocuenta(String numerocuenta) {
		this.numerocuenta = numerocuenta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipocuenta() {
		return tipocuenta;
	}

	public void setTipocuenta(String tipocuenta) {
		this.tipocuenta = tipocuenta;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public Long getEstado() {
		return estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
