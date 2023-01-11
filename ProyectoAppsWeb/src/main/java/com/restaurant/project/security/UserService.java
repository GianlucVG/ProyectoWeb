package com.restaurant.project.security;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.restaurant.project.entity.Usuario;
import com.restaurant.project.service.UsuarioService;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	private UsuarioService servicio;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails userDet=null;
		Usuario obj=servicio.loginUsuario(username);
		Set<GrantedAuthority> rol=new HashSet<GrantedAuthority>();
		rol.add(new SimpleGrantedAuthority(obj.getRol().getDescripcion()));
		userDet=new User(username,obj.getClave(),rol);
		return userDet;
	}
	
	
	
	
}
