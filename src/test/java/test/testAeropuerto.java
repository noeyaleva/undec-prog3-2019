package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testAeropuerto {

	@Test
	void testAeropuerto_BienFormado() {
		try {
			Cuidad c1 = new Ciudad(1, "Nonogasta", "5372");
			Aeropuerto a1 = new Aeropuerto(1, "Exeiza", c1, "12345");
			asserEquals("ID: 1 - Nombre: Exeiza - Ciudad: ID: 1 - Nombre: Nonogasta - Codigo Postal: 5372 - Codigo: 12345", a1.toString());
		} catch (ExceptionGeneral e) {
			fail("Esta línea no deberia Correrse");
		} catch (Exception e) {
			fail("Esta línea no deberia Correrse");
		}
	}
	
	@Test
	void testAeropuertoNombreMalFormado() {
		try {
			Cuidad c1 = new Ciudad(1, "Nonogasta", "5372");
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
			Cuidad c1 = new Ciudad(1, "Nonogasta", "5372");
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
			Cuidad c1 = new Ciudad(1, "Nonogasta", "5372");
			Aeropuerto a1 = new Aeropuerto(-1, "Exeiza", c1, "12345");
			fail("Esta linea no deberia correrse");
		} catch (ExceptionIdMalFormado e) {
			asserEquals("Error en el Id.", e.getMessage());
		} catch (ExceptionGeneral e) {
			fail("Esta linea no deberia correrse.");
		} catch (Exception e) {
			fail("Esta linea no deberia correrse.");
		}
	}
	
	@Test
	void testAeropuertoCodigoMalFormado() {
		try {
			Cuidad c1 = new Ciudad(1, "Nonogasta", "5372");
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
			Cuidad c1 = new Ciudad(1, "Nonogasta", "5372");
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
	}
}
