package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dominio.Ciudad;
import dominio.exceptions.ExceptionCodigoMalFormado;
import dominio.exceptions.ExceptionGeneral;
import dominio.exceptions.ExceptionIdMalFormado;
import dominio.exceptions.ExceptionNombreMalFormado;

class TestCiudad {

	@Test
	void testCiudad_BienFormado() {
		try {
			Ciudad c1 = new Ciudad(1, "Nonogasta", "5372");
			assertEquals("ID: 1 - Nombre: Nonogasta - Codigo Postal: 5372", c1.toString());
		} catch (ExceptionGeneral e) {
			fail("Esta línea no deberia Correrse");
		} catch (Exception e) {
			fail("Esta línea no deberia Correrse");
		}
	}

	@Test
	void testCiudadNombreMalFormado() {
		try {
			Ciudad c1 = new Ciudad(1, "", "5372");
			fail("Esta linea no deberia correrse");
			
		} catch(ExceptionNombreMalFormado ex) {
			assertEquals("Error en el nombre", ex.getMessage());
		} catch(ExceptionGeneral e) {
			fail("Esta linea no deberia correrse");
		} catch(Exception e) {
			fail("Esta linea no deberia correrse");
		}
		
		try {
			Ciudad c1 = new Ciudad(1, null, "1234");
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
	void testCiudadIdMalformado() {
		try {
			Ciudad c1 = new Ciudad(-1, "Nonogasta", "5372");
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
	void testCiudadCodigoPostalMalFormado() {
		try {
			Ciudad c1 = new Ciudad(1, "Nonogasta", "");
			fail("Esta linea no deberia correrse");
			
		} catch(ExceptionCodigoMalFormado e) {
			assertEquals("Error en el codigo postal", e.getMessage());
		} catch(ExceptionGeneral e) {
			fail("Esta linea no deberia correrse");
		} catch(Exception e) {
			fail("Esta linea no deberia correrse");
		}
		
		try {
			Ciudad c1 = new Ciudad(1, "Nonogasta" , null);
			fail("Esta linea no deberia correrse");
		} catch(ExceptionCodigoMalFormado e) {
			assertEquals("Error en el codigo postal", e.getMessage());
		} catch(ExceptionGeneral e) {
			fail("Esta linea no deberia correrse");
		} catch(Exception e) {
			fail("Esta linea no deberia correrse");
		}
	}

}
