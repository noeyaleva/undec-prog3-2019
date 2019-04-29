package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TestAvion {

	@Test
	void testAvion_BienFormado() {
		try {
			ArrayList<Asiento> misAsientos = new ArrayList<Asiento>(); 
			Avion a1 = new Avion(1, "modelo", "matricula", misAsientos);
			assertEquals("ID: 1 - Modelo: Modelo - Matricula: Matricula - Asientos: A1, A2", a1.toString());
		} catch (ExceptionGeneral e) {
			fail("Esta línea no deberia Correrse");
		} catch (Exception e) {
			fail("Esta línea no deberia Correrse");
		}
	}
	
	@Test
	void testAvionModeloMalFormado() {
		
		try {
			ArrayList<Asiento> misAsientos = new ArrayList<Asiento>(); 
			Avion a1 = new Avion(1, "", "matricula", misAsientos);
			fail("Esta linea no deberia correrse");
			
		} catch(ExceptionModeloMalFormado e) {
			assertEquals("Error en el modelo", e.getMessage());
		} catch(ExceptionGeneral e) {
			fail("Esta linea no deberia correrse");
		} catch(Exception e) {
			fail("Esta linea no deberia correrse");
		}
		
		try {
			ArrayList<Asiento> misAsientos = new ArrayList<Asiento>(); 
			Avion a1 = new Avion(1, null, "matricula", misAsientos);
			fail("Esta linea no deberia correrse");
		} catch(ExceptionModeloMalFormado e) {
			assertEquals("Error en el apellido", e.getMessage());
		} catch(ExceptionGeneral e) {
			fail("Esta linea no deberia correrse");
		} catch(Exception e) {
			fail("Esta linea no deberia correrse");
		}
	}
	
	@Test
	void testAvionMatriculaMalFormada() {
		try {
			ArrayList<Asiento> misAsientos = new ArrayList<Asiento>(); 
			Avion a1 = new Avion(1, "modelo", "", misAsientos);
			fail("Esta linea no deberia correrse");
			
		} catch(ExceptionMatriculaMalFormado e) {
			assertEquals("Error en la matricula", e.getMessage());
		} catch(ExceptionGeneral e) {
			fail("Esta linea no deberia correrse");
		} catch(Exception e) {
			fail("Esta linea no deberia correrse");
		}
		
		try {
			ArrayList<Asiento> misAsientos = new ArrayList<Asiento>(); 
			Avion a1 = new Avion(1, "modelo", null, misAsientos);
			fail("Esta linea no deberia correrse");
		} catch(ExceptionMatriculaMalFormado e) {
			assertEquals("Error en la matricula", e.getMessage());
		} catch(ExceptionGeneral e) {
			fail("Esta linea no deberia correrse");
		} catch(Exception e) {
			fail("Esta linea no deberia correrse");
		}
	}

}
