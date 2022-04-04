package com.gian.tallerJunit;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.gian.tallerJunit.model.Articulo;

@Service
public class BaseDatosImpl implements BaseDatosI {

	private Map<Integer, Articulo> baseDatos;

	@Override
	public void iniciar() {

		baseDatos = new HashMap<>();
		baseDatos.put(1, new Articulo("Camieta", 20D));
		baseDatos.put(2, new Articulo("Camieta2", 20D));
		baseDatos.put(3, new Articulo("Camieta3", 20D));
		baseDatos.put(4, new Articulo("Camieta4", 20D));

	}

	@Override
	public Integer insertarArticulo(Articulo articulo) {

		baseDatos.put(baseDatos.size() + 1, articulo);

		return baseDatos.size();
	}

	@Override
	public Articulo buscarArticulo(Integer identificador) {

		return baseDatos.get(identificador);
	}

	@Override
	public Integer agregarArticulo(Integer identificador, Articulo articulo) {

		baseDatos.put(identificador, articulo);
		
		return identificador;

	}

}
