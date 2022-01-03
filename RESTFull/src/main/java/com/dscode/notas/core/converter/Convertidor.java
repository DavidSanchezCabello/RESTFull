package com.dscode.notas.core.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dscode.notas.core.entity.Nota;
import com.dscode.notas.core.model.MNota;

@Component("convertidor")
public class Convertidor {
	public List<MNota> convertirLista(List<Nota> notas){
		List<MNota> mnotas = new ArrayList<>();
		//Rellenamos nuestra nueva lista de MNotas con el objeto Nota que le pasemos por parámetros, 
		//convirtiendo así el objeto Nota en MNota
		for (Nota nota : notas) {
			mnotas.add(new MNota(nota));
		}		
		return mnotas;
	}
}
