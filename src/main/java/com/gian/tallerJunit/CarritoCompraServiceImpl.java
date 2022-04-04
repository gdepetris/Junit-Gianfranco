package com.gian.tallerJunit;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.gian.tallerJunit.model.*;
import java.util.ArrayList;

public class CarritoCompraServiceImpl implements CarritoCompraServiceI {

	private List<Articulo> cesta = new ArrayList<>();

	@Autowired
	private BaseDatosI baseDatos;

	@Override
	public void limpiarCesta() {

		cesta.clear();

	}

	@Override
	public void addArticulo(Articulo articulo) {

		cesta.add(articulo);

	}

	@Override
	public Integer getNumArticulo() {

		return cesta.size();
	}

	@Override
	public List<Articulo> getArticulos() {

		return cesta;
	}

	@Override
	public Double totalPrice() {

		Double total = 0D;

		for (Articulo articulo : cesta) {
			total = total + articulo.getPrecio();

		}

		return total;
	}

	@Override
	public Double calculadorDescuento(Double precio, Double porcentaje) {

		return precio - precio * porcentaje / 100;
	}

	@Override
	public Double aplicarDescuento(Integer idArticulo, Double porcentaje) {

		baseDatos.iniciar();
		Articulo articulo = baseDatos.buscarArticulo(idArticulo);

		if (Optional.ofNullable(articulo).isPresent()) {
			return calculadorDescuento(articulo.getPrecio(), porcentaje);

		} else {

			System.out.println("No se ha encontrado el articulo con id asignado");

		}

		return 0D;
	}

	@Override
	public Integer addBaseDatos(Integer identificador, Articulo articulo) {

		
		cesta.add(articulo);

		return baseDatos.agregarArticulo(identificador, articulo);
	}

}
