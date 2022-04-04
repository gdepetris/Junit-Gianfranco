package com.gian.tallerJunit;

import com.gian.tallerJunit.model.*;
import java.util.List;

public interface CarritoCompraServiceI {

	public void limpiarCesta();
	
	public void addArticulo(Articulo articulo);
	
	public Integer getNumArticulo();
	
	public List<Articulo> getArticulos();
	
	public Double totalPrice();
	
	public Double calculadorDescuento(Double precio, Double porcentaje);
	
	public Double aplicarDescuento(Integer idArticulo, Double porcentaje);
	
	public Integer addBaseDatos(Integer identificador, Articulo articulo);
}
