package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dominio.Pasajero;
import dominio.exceptions.ExceptionApellidoMalFormado;
import dominio.exceptions.ExceptionCuilMalFormado;
import dominio.exceptions.ExceptionGeneral;
import dominio.exceptions.ExceptionIdMalFormado;
import dominio.exceptions.ExceptionNombreMalFormado;
import dominio.exceptions.ExceptionTelefonoMalFormado;

class TestPasajero {

	@Test
	void testPasajero_BienFormado() {
		try {
			Pasajero p1 = new Pasajero(1, "1234456", "lopez", "Javier", "03825123345");
			assertEquals("ID: 1 - Apellido y Nombre: Lopez, Javier - Tel: 03825123345", p1.toString());
		} catch (ExceptionGeneral e) {
			fail("Esta línea no deberia Correrse");
		} catch (Exception e) {
			fail("Esta línea no deberia Correrse");
		}
	}
	
	@Test
	void testPasajeroApellidomalFormado() {
		try {
			Pasajero p1 = new Pasajero(1, "1234456", "", "javier", "03825123345");
			fail("Esta linea no deberia correrse");
			
		} catch(ExceptionApellidoMalFormado e) {
			assertEquals("Error en el apellido", e.getMessage());
		} catch(ExceptionGeneral e) {
			fail("Esta linea no deberia correrse");
		} catch(Exception e) {
			fail("Esta linea no deberia correrse");
		}
		
		try {
			Pasajero p1 = new Pasajero(1, "1234456", null, "javier", "03825123345");
			fail("Esta linea no deberia correrse");
		} catch(ExceptionApellidoMalFormado e) {
			assertEquals("Error en el apellido", e.getMessage());
		} catch(ExceptionGeneral e) {
			fail("Esta linea no deberia correrse");
		} catch(Exception e) {
			fail("Esta linea no deberia correrse");
		}
	}
	
	@Test
	void testPasajeroNombreMalFormado() {
		try {
			Pasajero p1 = new Pasajero(1, "1234456", "lopez", "", "03825123345");
			fail("Esta linea no deberia correrse");
			
		} catch(ExceptionNombreMalFormado e) {
			assertEquals("Error en el nombre", e.getMessage());
		} catch(ExceptionGeneral e) {
			fail("Esta linea no deberia correrse");
		} catch(Exception e) {
			fail("Esta linea no deberia correrse");
		}
		
		try {
			Pasajero p1 = new Pasajero(1, "1234456", "lopez", null, "03825123345");
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
	void testPasajeroIdMalFormado() {
		try {
			Pasajero p1 = new Pasajero(-1, "1234456", "lopez", "Javier", "03825123345");
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
	void testPasajeroCuilMalFormado() {
		try {
			Pasajero p1 = new Pasajero(1, "", "lopez", "javier", "03825123345");
			fail("Esta linea no deberia correrse");
			
		} catch(ExceptionCuilMalFormado e) {
			assertEquals("Error en el cuil", e.getMessage());
		} catch(ExceptionGeneral e) {
			fail("Esta linea no deberia correrse");
		} catch(Exception e) {
			fail("Esta linea no deberia correrse");
		}
		
		try {
			Pasajero p1 = new Pasajero(1, null, "lopez", "javier", "03825123345");
			fail("Esta linea no deberia correrse");
		} catch(ExceptionCuilMalFormado e) {
			assertEquals("Error en el cuil", e.getMessage());
		} catch(ExceptionGeneral e) {
			fail("Esta linea no deberia correrse");
		} catch(Exception e) {
			fail("Esta linea no deberia correrse");
		}
	}

	@Test
	void testPasajeroTelefonoMalFormado() {
		try {
			Pasajero p1 = new Pasajero(1, "1234456", "lopez", "javier", "");
			fail("Esta linea no deberia correrse");
			
		} catch(ExceptionTelefonoMalFormado e) {
			assertEquals("Error en el telefono", e.getMessage());
		} catch(ExceptionGeneral e) {
			fail("Esta linea no deberia correrse");
		} catch(Exception e) {
			fail("Esta linea no deberia correrse");
		}
		
		try {
			Pasajero p1 = new Pasajero(1, "1234456", "lopez", "javier", null);
			fail("Esta linea no deberia correrse");
		} catch(ExceptionTelefonoMalFormado e) {
			assertEquals("Error en el telefono", e.getMessage());
		} catch(ExceptionGeneral e) {
			fail("Esta linea no deberia correrse");
		} catch(Exception e) {
			fail("Esta linea no deberia correrse");
		}
	}
}
