package com.mx.mwisp.mwsipfinal.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.mwisp.mwsipfinal.entity.Persona;
@Repository("personaJpaRepository")
public interface PersonaJpaRepository  extends JpaRepository<Persona, Serializable>{
	
}
