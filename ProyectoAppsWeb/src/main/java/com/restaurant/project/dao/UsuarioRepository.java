package com.restaurant.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.restaurant.project.entity.Enlace;
import com.restaurant.project.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	//select *from tb_usuario where login='aaa' and password='4444'
	@Query("select u from Usuario u where u.login=?1")
	public Usuario iniciarSesion(String vLogin);
	
	/*
	select e.idenlace,e.descripcion,e.ruta from tb_enlace e 
			join tb_rol_enlace ro on ro.idenlace=e.idenlace where ro.idrol=3
	*/
	@Query("select  e from RolEnlace re join re.enlace e where re.rol.idrol=?1")
	public List<Enlace> traerEnlacesDelUsuario(int codRol);
	
	
}
