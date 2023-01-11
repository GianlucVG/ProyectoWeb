package com.proyecto;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.restaurant.project.dao.PlatoRepository;
import com.restaurant.project.entity.Plato;
import com.restaurant.project.entity.TipoPlato;
import com.restaurant.project.service.impl.PlatoServiceImpl;

@SpringBootTest
class ProyectoAppsWebApplicationTests {

	@Autowired
	PlatoRepository repo;
	
	@Test
	void contextLoads() {
List<Plato> lista = repo.listPlatoCarta();
		
		for(Plato plato: lista) {
			System.out.println(plato.getNombre() + "-" + plato.getTipo().getNombre());
		}
	}

}
