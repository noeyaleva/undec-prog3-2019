package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class TestPiloto {

	@Test
	void testPiloto_BienFormado() {
		
		try {
			LocalDate d1 = new LocalDate(1,3,1990); 
			Piloto p1 = new Piloto(1, "Juarez", "Enrique", "12345678", d1);
			asserEquals("ID: 1 - Apellido y Nombre: Juarez, Enrique - DNI: 12345678", p1.toString());
		}catch (ExceptionGeneral e) {
			fail("Esta línea no deberia Correrse");
		} catch (Exception e) {
			fail("Esta línea no deberia Correrse");
		}
	}
	
	@Test
	void testPilotoApellidoMalFormado() {
		try {
			LocalDate d1 = new LocalDate(1,3,1990); 
			Piloto p1 = new Piloto(1, "", "Enrique", "12345678", d1);
			fail("Esta linea no deberia correrse");
			
		} catch(ExceptionApellidoMalFormado e) {
			assertEquals("Error en el apellido", e.getMessage());
		} catch(ExceptionGeneral e) {
			fail("Esta linea no deberia correrse");
		} catch(Exception e) {
			fail("Esta linea no deberia correrse");
		}
		
		try {
			LocalDate d1 = new LocalDate(1,3,1990); 
			Piloto p1 = new Piloto(1, null, "Enrique", "12345678", d1);
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
	void testPilotoNombreMalFormado() {
		try {
			LocalDate d1 = new LocalDate(1,3,1990); 
			Piloto p1 = new Piloto(1, "Juarez", "", "12345678", d1);
			fail("Esta linea no deberia correrse");
			
		} catch(ExceptionNombreMalFormado e) {
			assertEquals("Error en el nombre", e.getMessage());
		} catch(ExceptionGeneral e) {
			fail("Esta linea no deberia correrse");
		} catch(Exception e) {
			fail("Esta linea no deberia correrse");
		}
		
		try {
			LocalDate d1 = new LocalDate(1,3,1990); 
			Piloto p1 = new Piloto(1, "Juarez", null, "12345678", d1);
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
	void testPilotoDniMalFormado() {
		try {
			LocalDate d1 = new LocalDate(1,3,1990); 
			Piloto p1 = new Piloto(1, "Juarez", "Enrique", "", d1);
			fail("Esta linea no deberia correrse");
			
		} catch(ExceptionCuilMalFormado e) {
			assertEquals("Error en el documento", e.getMessage());
		} catch(ExceptionGeneral e) {
			fail("Esta linea no deberia correrse");
		} catch(Exception e) {
			fail("Esta linea no deberia correrse");
		}
		
		try {
			LocalDate d1 = new LocalDate(1,3,1990); 
			Piloto p1 = new Piloto(1, "Juarez", "Enrique", "12345678", d1);
			fail("Esta linea no deberia correrse");
		} catch(ExceptionCuilMalFormado e) {
			assertEquals("Error en el documento", e.getMessage());
		} catch(ExceptionGeneral e) {
			fail("Esta linea no deberia correrse");
		} catch(Exception e) {
			fail("Esta linea no deberia correrse");
		}
	}
	
}
