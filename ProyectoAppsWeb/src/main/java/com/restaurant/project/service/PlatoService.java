package com.restaurant.project.service;

import java.util.List;

import com.restaurant.project.entity.Plato;

public interface PlatoService {
	
	public List<Plato> listarPlatos();
	
	public List<Plato> listarPlatosCriollos();
	
	public List<Plato> listarPlatosFrios();
	
	public List<Plato> listarPlatosCarta();
	
	public Plato guardarPlato(Plato bean);
	
	public Plato buscarPlato(Long id);
	
	public void actualizarFoto(String archivo, Long id);

}
