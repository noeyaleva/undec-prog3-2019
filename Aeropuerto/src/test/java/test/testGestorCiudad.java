package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import dominio.Ciudad;
import dominio.GestorPaginaWeb;
import dominio.exceptions.ExceptionGeneral;

class testGestorCiudad {

	@Test
	void testSoySingleton() {
		GestorCiudad gc1 = GestorCiudad.getInstancia();
		GestorCiudad gc2 = GestorCiudad.getInstancia();
		assertEquals(true,gc1.equals(gc2));
		assertEquals(true,gc1==gc2);
	}
	
	@Test
	void testCrearCiudad() {
		try {
			assertEquals(true, GestorCiudad.getInstancia().CrearCiudad(ciudad));
		} catch(ExceptionGeneral e) {
			fail("esta linea no deberia ejecutarse");
		} catch (Exception e) {
			fail("Esta linea no deberia ejecutarse");
		}
	}
	
	@Test
	void testCiudadModificar() {
		try {
			Ciudad ciudad = new Ciudad(1, "Nonogasta", "5372");
			
			assertEquals(true, GestorCiudad.getInstancia().ModificarCiudad(2, null, null));
			assertEquals("ID: 2 - Nombre: Nonogasta - Codigo Postal: 5372", ciudad.toString());
		} catch(ExceptionGeneral e) {
			fail("esta linea no deberia ejecutarse");
		} catch (Exception e) {
			fail("Esta linea no deberia ejecutarse");
		}
		
		try {
			Ciudad ciudad = new Ciudad(1, "Nonogasta", "5372");
			
			assertEquals(true, GestorCiudad.getInstancia().ModificarCiudad(-1,"Chilecito",null));
			assertEquals("ID: 1 - Nombre: Chilecito - Codigo Postal: 5372", ciudad.toString());
		} catch(ExceptionGeneral e) {
			fail("esta linea no deberia ejecutarse");
		} catch (Exception e) {
			fail("Esta linea no deberia ejecutarse");
		}
		
		try {
			Ciudad ciudad = new Ciudad(1, "Nonogasta", "5372");
			
			assertEquals(true, GestorCiudad.getInstancia().ModificarCiudad(-1, null,"5070"));
			assertEquals("ID: 1 - Nombre: Nonogasta - Codigo Postal: 5070", ciudad.toString());
		} catch(ExceptionGeneral e) {
			fail("esta linea no deberia ejecutarse");
		} catch (Exception e) {
			fail("Esta linea no deberia ejecutarse");
		}
	}
	
	@Test
	void testCiudadBorrar() {
		try {
			Ciudad  c1 = Ciudad(1, "Nonogasta", "5372");
			assertEquals(true, GestorCiudad.getInstancia().BorrarCiudad(c1));
		} catch(ExceptionGeneral e) {
			fail("esta linea no deberia ejecutarse");
		} catch (Exception e) {
			fail("Esta linea no deberia ejecutarse");
		}
		
		try {
			Ciudad  c1 = Ciudad(2, "Nonogasta", "5372");
			assertEquals(true, GestorCiudad.getInstancia().BorrarCiudad(c1));
		} catch(ExceptionGeneral e) {
			fail("esta linea no deberia ejecutarse");
		} catch (Exception e) {
			fail("Esta linea no deberia ejecutarse");
		}
	}
	
	@Test
	void testCiudadTraerUno() {
		try {
			Ciudad  c1 = Ciudad(1, "Nonogasta", "5372");
			
			assertEquals(true,c1.equals(GestorCiudad.getInstancia().TraerUnaCiudad(1)));
		} catch(ExceptionGeneral e) {
			fail("esta linea no deberia ejecutarse");
		} catch (Exception e) {
			fail("Esta linea no deberia ejecutarse");
		}
		
		try {
			Ciudad  c1 = Ciudad(2, "Nonogasta", "5372");
			assertEquals(false, c1.equals(GestorCiudad.getInstancia().TraerUnaCiudad(1)));
		} catch(ExceptionGeneral e) {
			fail("esta linea no deberia ejecutarse");
		} catch (Exception e) {
			fail("Esta linea no deberia ejecutarse");
		}
	}
	
	@Test
	void testCiudadTraerTodo() {
		try {
			List<Ciudad> misCiudades = new ArrayList<Ciudad>();
			
			Ciudad  c1 = Ciudad(1, "Nonogasta", "5372");
			Ciudad  c2 = Ciudad(2, "Chilecito", "5373");
			Ciudad  c3 = Ciudad(3, "Vichigasta", "5352");
			
			misCiudades.add(c1);
			misCiudades.add(c2);
			misCiudades.add(c3);
			
			List<Ciudad> misCiudades1 = new ArrayList<Ciudad>();
			misCiudades1 = GestorCiudad.getInstancia().TraerTodoCiudad();
			
			assertEquals(misCiudades.size(), misCiudades1.size());
		} catch(ExceptionGeneral e) {
			fail("esta linea no deberia ejecutarse");
		} catch (Exception e) {
			fail("Esta linea no deberia ejecutarse");
		}
	}
	
	@Test
	void testCiudadTraerPorCriterio() {
		try {
			Ciudad  c1 = Ciudad(1, "Nonogasta", "5372");
			
			assertEquals(true,c1.equals(GestorCiudad.getInstancia().TraerPorCriterioCiudad("Nonogasta")));
		} catch(ExceptionGeneral e) {
			fail("esta linea no deberia ejecutarse");
		} catch (Exception e) {
			fail("Esta linea no deberia ejecutarse");
		}
		
		try {
			Ciudad  c1 = Ciudad(1, "Nonogasta", "5372");
			
			assertEquals(false,c1.equals(GestorCiudad.getInstancia().TraerPorCriterioCiudad("Vichigasta")));
		} catch(ExceptionGeneral e) {
			fail("esta linea no deberia ejecutarse");
		} catch (Exception e) {
			fail("Esta linea no deberia ejecutarse");
		}
	}
}
