package com.appuf.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appuf.model.entity.UnidadeFederativa;

@Repository
public interface UnidadeFederativaDAO extends JpaRepository<UnidadeFederativa, Long> {
	
	List<UnidadeFederativa> findAllByOrderByIdDesc();

}
