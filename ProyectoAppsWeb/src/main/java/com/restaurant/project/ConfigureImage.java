package com.restaurant.project;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfigureImage implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addResourceHandlers(registry);
		//Configurar para que spring reconozca carpetas fuera del mismo proyecto
		//1(alias) | 2(ruta de la carpeta)
		registry.addResourceHandler("/foto/**").addResourceLocations("file:/c:/fotosProyectoWeb/");
	}
	
}
