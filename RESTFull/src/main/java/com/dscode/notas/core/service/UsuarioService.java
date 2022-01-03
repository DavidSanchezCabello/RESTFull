//package com.dscode.notas.core.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.dscode.notas.core.entity.Usuario;
//import com.dscode.notas.core.repository.GestorUsuario;
//
//@Service("usuarioService")
//public class UsuarioService implements UserDetailsService{
//
//	//Clase para autentificar el acceso
//	
//	@Autowired
//	@Qualifier("gestorUsuario")
//	private GestorUsuario repo;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Usuario user = repo.findByUsuario(username);
//		return new User(user.getUsuario(), user.getContrasena(), 
//				user.isActivo(), user.isActivo(), user.isActivo(), user.isActivo(), buildgrante(user.getRol()));
//	}
//	
//	public List<GrantedAuthority> buildgrante(byte rol){
//		// Creamos un vector con los tres posibles roles
//		String[] roles = {"LECTOR", "USUARIO", "ADMINISTRADOR"};
//		List<GrantedAuthority> auths = new ArrayList<>();
//		// rellenamos el listado de GrantedAuthority
//		for (int i = 0; i < rol; i++) {
//			auths.add(new SimpleGrantedAuthority(roles[i]));
//		}
//		return auths;
//	}
//}
