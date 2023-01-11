package com.restaurant.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.project.dao.TipoPlatoRepository;
import com.restaurant.project.entity.TipoPlato;
import com.restaurant.project.service.TipoPlatoService;

@Service
public class TipoPlatoServiceImpl implements TipoPlatoService{

	@Autowired
	TipoPlatoRepository repo;
	
	@Override
	public List<TipoPlato> listarTipos() {
		return repo.findAll();
	}

}
