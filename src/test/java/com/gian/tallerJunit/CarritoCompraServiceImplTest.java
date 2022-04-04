package com.gian.tallerJunit;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.gian.tallerJunit.model.Articulo;

@RunWith(MockitoJUnitRunner.class)
public class CarritoCompraServiceImplTest {

	@InjectMocks
	private CarritoCompraServiceI carritoService = new CarritoCompraServiceImpl();

	@Mock
	private BaseDatosI baseDatos;

	@Test
	public void testLimpiarCesta() {

		carritoService.addArticulo(new Articulo("Camiseta", 15.99D));
		assertFalse(carritoService.getArticulos().isEmpty());
		carritoService.limpiarCesta();
		assertTrue(carritoService.getArticulos().isEmpty());

	}

	@Test
	public void testAddArticulo() {

		assertTrue(carritoService.getArticulos().isEmpty());
		carritoService.addArticulo(new Articulo("Camiseta", 15.99D));
		assertFalse(carritoService.getArticulos().isEmpty());

	}

	@Test
	public void testGetNumArticulo() {

		carritoService.addArticulo(new Articulo("Camiseta", 15.99D));
		carritoService.addArticulo(new Articulo("Camiseta2", 15.99D));
		assertTrue(carritoService.getNumArticulo() == 2);
		carritoService.addArticulo(new Articulo("Camiseta3", 15.99D));
		assertTrue(carritoService.getNumArticulo() == 3);

	}

	@Test
	public void testGetArticulos() {

		assertTrue(carritoService.getArticulos().isEmpty());
		carritoService.addArticulo(new Articulo("Camiseta", 15.99D));
		assertFalse(carritoService.getArticulos().isEmpty());

	}

	@Test
	public void testTotalPrice() {

		carritoService.addArticulo(new Articulo("Camiseta", 15.99D));
		carritoService.addArticulo(new Articulo("Camiseta2", 20D));
		assertTrue(carritoService.totalPrice() == 35.99D);
		carritoService.addArticulo(new Articulo("Camiseta", 2D));
		assertTrue(carritoService.totalPrice() == 37.99D);

	}

	@Test
	public void testCalculadorDescuento() {

		carritoService.addArticulo(new Articulo("Camiseta", 20D));
		assertTrue(carritoService.calculadorDescuento(carritoService.totalPrice(), 10D) == 18D);

	}

	@Test
	public void testAplicarDescuento() {

		Articulo articulo = new Articulo("Pantalon", 20D);
		when(baseDatos.buscarArticulo(any(Integer.class))).thenReturn(articulo);
		Double res = carritoService.aplicarDescuento(1, 10D);
		assertTrue(res == 18D);

	}

	@Test
	public void testAddBaseDatos() {

		Articulo articulo = new Articulo("Zapatillas", 20D);
		assertTrue(carritoService.getArticulos().isEmpty());
		when(baseDatos.agregarArticulo(1, articulo)).thenReturn(1);
		Integer res = carritoService.addBaseDatos(1, articulo);
		assertTrue(res == 1);
		assertFalse(carritoService.getArticulos().isEmpty());

		carritoService.getArticulos().contains(articulo);

		verify(baseDatos, times(1)).agregarArticulo(1, articulo);

	}

}
