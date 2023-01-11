package com.restaurant.project.controller;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.restaurant.project.entity.Plato;
import com.restaurant.project.entity.TipoPlato;
import com.restaurant.project.service.impl.PlatoServiceImpl;
import com.restaurant.project.service.impl.TipoPlatoServiceImpl;

@Controller
@RequestMapping("/platos")
public class PlatoController {
	
	@Autowired
	PlatoServiceImpl servicioPlato;
	@Autowired
	TipoPlatoServiceImpl servicioTipo;
	
	@RequestMapping("/")
	public String listar(Model model) {
		
		List<Plato> listaPlatos = servicioPlato.listarPlatos();
		List<TipoPlato> listaTipos = servicioTipo.listarTipos();
		
		model.addAttribute("platos", listaPlatos);
		model.addAttribute("tipos", listaTipos);
		
		return "plato";
	}
	
	@RequestMapping("/criollo")
	public String listarCriollos(Model model) {
		
		List<Plato> listaPlatos = servicioPlato.listarPlatosCriollos();
		model.addAttribute("platosCriollos", listaPlatos);
		
		return "menuCriollo";
	}
	
	@RequestMapping("/frio")
	public String listarFrios(Model model) {
		
		List<Plato> listaPlatos = servicioPlato.listarPlatosFrios();
		model.addAttribute("platosFrios", listaPlatos);
		
		return "platosFrios";
	}
	
	@RequestMapping("/carta")
	public String listarCarta(Model model) {
		
		List<Plato> listaPlatos = servicioPlato.listarPlatosCarta();
		model.addAttribute("platosCarta", listaPlatos);
		
		return "platosCarta";
	}
	
	@RequestMapping("/guardar")
	public String guardar(@RequestParam("codigo") Long id, @RequestParam("nombre") String nom,
							@RequestParam("descripcion") String desc, @RequestParam("precio") Double precio, 
							@RequestParam("tipo") Long tipo, RedirectAttributes redirect) {
		try {
			TipoPlato tipoPlato = new TipoPlato(tipo);
			
			Plato plato = new Plato(id, nom, desc, new BigDecimal(precio), tipoPlato);
			
			servicioPlato.guardarPlato(plato);
		
			if(id == 0) {
				redirect.addFlashAttribute("MENSAJE", "Plato registrado correctamente");
			}else {
				redirect.addFlashAttribute("MENSAJE", "Plato actualizado correctamente");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			redirect.addFlashAttribute("MENSAJE", "Error");
		}

		
		return "redirect:/platos/";
	}
	
	@RequestMapping("/buscar/{id}")
	@ResponseBody
	public Plato buscar(@PathVariable Long id) {
		return servicioPlato.buscarPlato(id);
	}
	
	
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id, RedirectAttributes redirect) {
		try {
			Plato plato = servicioPlato.buscarPlato(id);
			plato.setEstado(2);
			servicioPlato.guardarPlato(plato);
			redirect.addFlashAttribute("MENSAJE", "Plato eliminado correctamente");
		}catch(Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("MENSAJE", "Error al eliminar");
		}
		return "redirect:/platos/";
		
	}
	
	@RequestMapping("/actualizar-foto")
	public String actualizarFoto(@RequestParam("data") MultipartFile file, @RequestParam("codigoFoto") Long id,
													RedirectAttributes redirect) {
		 try {
	            String nomArchivo = file.getOriginalFilename();
	            byte[] bytesArchivo = file.getBytes();
	            String ruta = "c://fotosProyectoWeb//";
	            //Generar archivo con la clase "Files"
	            Files.write(Paths.get(ruta + nomArchivo), bytesArchivo);
	            
	            servicioPlato.actualizarFoto(nomArchivo, id);
	            redirect.addFlashAttribute("MENSAJE","Foto actualizada");
	        }catch (Exception e){
	            e.printStackTrace();
	            redirect.addFlashAttribute("MENSAJE","Error");
	        }
	        return "redirect:/platos/";
		
	}
	
	
	
	
	
	

}
