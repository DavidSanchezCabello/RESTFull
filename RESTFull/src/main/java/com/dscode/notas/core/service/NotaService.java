package com.dscode.notas.core.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dscode.notas.core.converter.Convertidor;
import com.dscode.notas.core.entity.Nota;
import com.dscode.notas.core.model.MNota;
import com.dscode.notas.core.repository.NotaRepositorio;

@Service("servicio")
public class NotaService {

	// Inyectar nuestra clase NotaRepositorio
	@Autowired
	@Qualifier("repositorio")
	private NotaRepositorio repositorio;
	
	// Inyectar nuestra clase Convertidor
	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;
	
	// Insertar Logs en nuestra aplicación
	private static final Log logger = LogFactory.getLog(NotaService.class);
	
	public boolean crear(Nota nota) {
		logger.info("Creando nota...");
		try {
			repositorio.save(nota);
			logger.info("Nota creada con éxito!!");
			return true;
		} catch (Exception e) {
			logger.error("Hubo un error");
			return false;
		}
	}
	
	public boolean actualizar(Nota nota) {
		logger.info("Actualizando nota...");
		try {			
			repositorio.save(nota);
			logger.info("Nota actualizada con éxito!!");
			return true;
		} catch (Exception e) {
			logger.error("Hubo un error");
			return false;
		}
	}
	
	public boolean borrar(String nombre, long id) {
		logger.warn("Borrando nota...");
		try {			
			Nota nota = repositorio.findByNombreAndId(nombre, id);			
			repositorio.delete(nota);
			logger.info("Nota borrada con éxito!!");
			return true;
		} catch (Exception e) {
			logger.error("Hubo un error");
			return false;
		}
	}
	
	public List<MNota> obtener() {	
		logger.info("Obteniendo todos los elementos...");
		return convertidor.convertirLista(repositorio.findAll());
	}
	
	public MNota obtenerPorNombreTitulo(String nombre, String titulo) {
		logger.info("Obteniendo los elementos por nombre y título...");
		return new MNota(repositorio.findByNombreAndTitulo(nombre, titulo));
	}
	
	public List<MNota> obtenerTitulo(String titulo){
		logger.info("Obteniendo los elementos por título...");
		return convertidor.convertirLista(repositorio.findByTitulo(titulo));
	}
	
	// Paginación
	public List<MNota> obtenerPorPaginacion(Pageable pageable){
		return convertidor.convertirLista(repositorio.findAll(pageable).getContent());
	}
}
