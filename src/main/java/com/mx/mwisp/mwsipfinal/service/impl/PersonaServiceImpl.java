package com.mx.mwisp.mwsipfinal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mx.mwisp.mwsipfinal.dao.PersonaJpaRepository;
import com.mx.mwisp.mwsipfinal.entity.Persona;
import com.mx.mwisp.mwsipfinal.service.PersonaService;

@Service("personaServiceImpl")
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	@Qualifier("personaJpaRepository")
	private PersonaJpaRepository personaJpaRepository;
	
	@Override
	public Persona addPersona(Persona Persona) {
		// TODO Auto-generated method stub
		return personaJpaRepository.save(Persona);
	}

}
