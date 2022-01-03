//package com.dscode.notas.core.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import com.dscode.notas.core.service.UsuarioService;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurity extends WebSecurityConfigurerAdapter{
//	
//	@Autowired
//	@Qualifier("usuarioService")
//	private UsuarioService userdetailservice;
//
//	// Dando clic derecho/source/Override/implement Metods... y sobreescribimos los siguientes métodos
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userdetailservice);
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable().authorizeRequests()
//		.antMatchers("/login").permitAll() //permitimos el acceso a /login a cualquiera
//		.anyRequest().authenticated() //cualquier otra petición requiere otra autenticación
//		.and()
//		// Las peticiones /login pasarán previamente por este filtro
//		.addFilterBefore(new LoginFilter("/login", authenticationManager()),
//			UsernamePasswordAuthenticationFilter.class)
//		
//		// Las demás peticiones pasarán por este filtro para validar el token
//		.addFilterBefore(new JwtFilter(),
//			UsernamePasswordAuthenticationFilter.class);
//	}
//	
//	
//
//}
