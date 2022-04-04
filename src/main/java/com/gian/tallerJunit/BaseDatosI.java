package com.gian.tallerJunit;

import com.gian.tallerJunit.model.Articulo;

public interface BaseDatosI {

	public void iniciar();
	
	public Integer insertarArticulo(Articulo articulo);
	
	public Articulo buscarArticulo(Integer identificador);
	
	public Integer agregarArticulo(Integer identificador, Articulo articulo);
	
}
