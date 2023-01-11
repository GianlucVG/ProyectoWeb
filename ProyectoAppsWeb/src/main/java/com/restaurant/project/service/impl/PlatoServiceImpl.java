package com.restaurant.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.project.dao.PlatoRepository;
import com.restaurant.project.entity.Plato;
import com.restaurant.project.service.PlatoService;

@Service
public class PlatoServiceImpl implements PlatoService{

	@Autowired
	PlatoRepository repo;
	
	@Override
	public List<Plato> listarPlatos() {
		return repo.listPlatos();
	}

	@Override
	public Plato guardarPlato(Plato bean) {
		return repo.save(bean);
	}

	@Override
	public Plato buscarPlato(Long id) {
		return repo.findById(id).orElseThrow(null);
	}

	@Override
	public List<Plato> listarPlatosCriollos() {
		return repo.listPlatoCriollo();
	}

	@Override
	public List<Plato> listarPlatosFrios() {
		return repo.listPlatoFrio();
	}

	@Override
	public List<Plato> listarPlatosCarta() {
		return repo.listPlatoCarta();
	}

	@Override
	public void actualizarFoto(String archivo, Long id) {
		repo.updatePhoto(archivo, id);
	}

}
