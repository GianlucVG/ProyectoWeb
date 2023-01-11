package com.restaurant.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.restaurant.project.entity.Plato;

public interface PlatoRepository extends JpaRepository<Plato, Long>{
	
	@Transactional
	@Modifying
	@Query(value = "update Plato p set  p.archivo= :archivo where p.id = :id")
	public void updatePhoto(String archivo, Long id);
	
	@Query(value = "select p from Plato p where p.estado = 1")
	public List<Plato> listPlatos();
	
	@Query(value = "select p from Plato p where p.tipo.id = 1 and p.estado = 1")
	public List<Plato> listPlatoFrio();
	
	@Query(value = "select p from Plato p where p.tipo.id = 2 and p.estado = 1")
	public List<Plato> listPlatoCriollo();
	
	@Query(value = "select p from Plato p where p.tipo.id = 3 and p.estado = 1")
	public List<Plato> listPlatoCarta();
	
}
