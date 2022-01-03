//package com.dscode.notas.core.configuration;
//
//import java.util.Collection;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//public class JwtUtil {
//	
//	// Método para crear el JWT y enviarlo al cliente en el header de la respuesta
//	static void addAuthentication(HttpServletResponse res, String username) {
//		
//		String token = Jwts.builder()
//				.setSubject(username)
//				
//				// Hash con el que firmaremos la clave
//				.signWith(SignatureAlgorithm.HS512, "P@atit0")
//				.compact();
//		
//		//agregamos al encabezado el token
//		res.addHeader("Authorization", "Bearer " + token);
//	}
//	
//	//Método para validación del token enviado por el cliente
//	static Authentication getAuthentication(HttpServletRequest request) {
//		
//		//Obtenemos el token que viene en el encabezado de la petición
//		String token = request.getHeader("Authorization");
//		
//		// si hay un token presente entonces lo validamos
//		if(token != null) {
//			String user = Jwts.parser()
//					.setSigningKey("P@atit0")
//					.parseClaimsJws(token.replace("Bearer", ""))
//					.getBody()
//					.getSubject();
//			// Recordamos que para las demás peticiones que no sean /login
//			//no requerimos una autenticacion por username/password
//			//por este motivo podemos devolver un UsernamePasswordAuthenticationToken sin password
//			return user != null ?
//					new UsernamePasswordAuthenticationToken(user, null, emptyList()) :
//						null;
//		}
//		return null;
//	}
//
//	private static Collection<? extends GrantedAuthority> emptyList() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}
