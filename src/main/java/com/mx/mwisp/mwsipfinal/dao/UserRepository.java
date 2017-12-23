package com.mx.mwisp.mwsipfinal.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.mwisp.mwsipfinal.entity.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Serializable>{
	public abstract User findByUsuario(String username);

}
