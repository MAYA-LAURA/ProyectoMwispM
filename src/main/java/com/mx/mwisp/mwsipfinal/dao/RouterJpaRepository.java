package com.mx.mwisp.mwsipfinal.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.mwisp.mwsipfinal.entity.Router;

@Repository("routerJpaRepository")
public interface RouterJpaRepository extends JpaRepository<Router, Serializable> {

}
