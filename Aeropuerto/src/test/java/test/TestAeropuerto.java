package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dominio.Aeropuerto;
import dominio.Ciudad;
import dominio.exceptions.ExceptionCiudadMalFormado;
import dominio.exceptions.ExceptionCodigoMalFormado;
import dominio.exceptions.ExceptionGeneral;
import dominio.exceptions.ExceptionIdMalFormado;
import dominio.exceptions.ExceptionNombreMalFormado;

class TestAeropuerto {

	@Test
	void testAeropuerto_BienFormado() {
		try {
			Ciudad c1 = new Ciudad(1, "Nonogasta", "5372");
			Aeropuerto a1 = new Aeropuerto(1, "Exeiza", c1, "12345");
			assertEquals("ID: 1 - Nombre: Exeiza - Ciudad: ID: 1 - Nombre: Nonogasta - Codigo Postal: 5372 - Codigo: 12345", a1.toString());
		} catch (ExceptionGeneral e) {
			fail("Esta línea no deberia Correrse");
		} catch (Exception e) {
			fail("Esta línea no deberia Correrse");
		}
	}
	
	@Test
	void testAeropuertoNombreMalFormado() {
		try {
			Ciudad c1 = new Ciudad(1, "Nonogasta", "5372");
			Aeropuerto a1 = new Aeropuerto(1, "", c1, "12345");
			fail("Esta linea no deberia correrse");
			
		} catch(ExceptionNombreMalFormado e) {
			assertEquals("Error en el nombre", e.getMessage());
		} catch(ExceptionGeneral e) {
			fail("Esta linea no deberia correrse");
		} catch(Exception e) {
			fail("Esta linea no deberia correrse");
		}
		
		try {
			Ciudad c1 = new Ciudad(1, "Nonogasta", "5372");
			Aeropuerto a1 = new Aeropuerto(1, null, c1, "12345");
			fail("Esta linea no deberia correrse");
		} catch(ExceptionNombreMalFormado e) {
			assertEquals("Error en el nombre", e.getMessage());
		} catch(ExceptionGeneral e) {
			fail("Esta linea no deberia correrse");
		} catch(Exception e) {
			fail("Esta linea no deberia correrse");
		}
	}

	@Test
	void testAeropuertoIdMalFormado() {
		try {
			Ciudad c1 = new Ciudad(1, "Nonogasta", "5372");
			Aeropuerto a1 = new Aeropuerto(-1, "Exeiza", c1, "12345");
			fail("Esta linea no deberia correrse");
		} catch (ExceptionIdMalFormado e) {
			assertEquals("Error en el Id.", e.getMessage());
		} catch (ExceptionGeneral e) {
			fail("Esta linea no deberia correrse.");
		} catch (Exception e) {
			fail("Esta linea no deberia correrse.");
		}
	}
	
	@Test
	void testAeropuertoCodigoMalFormado() {
		try {
			Ciudad c1 = new Ciudad(1, "Nonogasta", "5372");
			Aeropuerto a1 = new Aeropuerto(1, "Exeiza", c1, "");
			fail("Esta linea no deberia correrse");
			
		} catch(ExceptionCodigoMalFormado e) {
			assertEquals("Error en el codigo", e.getMessage());
		} catch(ExceptionGeneral e) {
			fail("Esta linea no deberia correrse");
		} catch(Exception e) {
			fail("Esta linea no deberia correrse");
		}
		
		try {
			Ciudad c1 = new Ciudad(1, "Nonogasta", "5372");
			Aeropuerto a1 = new Aeropuerto(1, "Exeiza", c1, null);
			fail("Esta linea no deberia correrse");
		} catch(ExceptionCodigoMalFormado e) {
			assertEquals("Error en el codigo", e.getMessage());
		} catch(ExceptionGeneral e) {
			fail("Esta linea no deberia correrse");
		} catch(Exception e) {
			fail("Esta linea no deberia correrse");
		}
	}
	/*
	@Test
	void testAeropuertoCiudadMalFormado() {
		try {
			Aeropuerto a1 = new Aeropuerto(1, "Exeiza", null, "12345");
			fail("Esta linea no deberia correrse");
		} catch(ExceptionCiudadMalFormado e) {
			assertEquals("Error en la ciudad", e.getMessage());
		} catch(ExceptionGeneral e) {
			fail("Esta linea no deberia correrse");
		} catch(Exception e) {
			fail("Esta linea no deberia correrse");
		}
	}*/
}
