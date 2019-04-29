package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestAerolinea {

	@Test
	void testAerolinea_NombreBienFormado() {
		try {
			Aerolinea a1 = new Aerolinea(1, "Argentinas");
			assertEquals(" ID: 1 - Nombre: Argentinas",a1.toString());
			
		} catch (ExceptionGeneral e) {
			fail("Esta linea no deberia correrse");
		} catch (Exception e) {
			fail("Esta linea no deberia correrse");
		}
		
	}
	
	@Test
	void testNombreMalFormado() {
		try {
			Aerolinea a1 = new Aerolinea(1, "");
			fail("Esta linea no deberia correrse");
		} catch(ExceptionNombreMalFormado e) {
			assertEquals("Error en el nombre", e.getMessage());
		} catch(ExceptionGeneral e) {
			fail("Esta linea no deberia correrse");
		} catch(Exception e) {
			fail("Esta linea no deberia correrse");
		}
		
		try {
			Aerolinea a1 = new Aerolinea(1, null);
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
	void testIdMalFormado() {
		try {
			Aerolinea a1 = new Aerolinea(-1, "Argentinas");
			fail("Esta linea no deberia correrse");
		} catch (ExceptionIdMalFormado e) {
			asserEquals("Error en el Id.", e.getMessage());
		} catch (ExceptionGeneral e) {
			fail("Esta linea no deberia correrse.");
		} catch (Exception e) {
			fail("Esta linea no deberia correrse.");
		}
		
	}

}
