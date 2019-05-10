package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import dominio.Asiento;
import dominio.exceptions.ExceptionGeneral;
import dominio.exceptions.ExceptionIdMalFormado;
import dominio.exceptions.ExceptionNumeroMalFormado;

class TestAsiento {

	@Test
	void testAsiento_BienFormado() {
		try {
			Asiento a1 = new Asiento(1, "a1");
			assertEquals("ID: 1 - N°: A1", a1.toString());
		} catch (ExceptionGeneral e) {
			fail("Esta línea no deberia Correrse");
		} catch (Exception e) {
			fail("Esta línea no deberia Correrse");
		}
	}
	
	@Test
	void testAsientoIdMalFormado() {
		try {
			Asiento a1 = new Asiento(-1, "A1");
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
	void testAsientoNumeroMalFormado() {
		try {
			Asiento a1 = new Asiento(1, "");
			fail("Esta linea no deberia correrse");
			
		} catch(ExceptionNumeroMalFormado e) {
			assertEquals("Error en el numero de asiento", e.getMessage());
		} catch(ExceptionGeneral e) {
			fail("Esta linea no deberia correrse");
		} catch(Exception e) {
			fail("Esta linea no deberia correrse");
		}
		
		try {
			Asiento a1 = new Asiento(1, null);
			fail("Esta linea no deberia correrse");
		} catch(ExceptionNumeroMalFormado e) {
			assertEquals("Error en el numero de asiento", e.getMessage());
		} catch(ExceptionGeneral e) {
			fail("Esta linea no deberia correrse");
		} catch(Exception e) {
			fail("Esta linea no deberia correrse");
		}
	}

}
