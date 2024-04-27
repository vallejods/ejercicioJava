package com.ejercicio.java.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ejercicio.java.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Long>{
	
	Cliente findByIdentificacion(@Param ("identificacion") String identificacion); 

}
