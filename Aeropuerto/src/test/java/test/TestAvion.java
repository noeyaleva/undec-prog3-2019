package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import dominio.Aeropuerto;
import dominio.Asiento;
import dominio.Avion;
import dominio.Ciudad;
import dominio.exceptions.ExceptionGeneral;
import dominio.exceptions.ExceptionIdMalFormado;
import dominio.exceptions.ExceptionMatriculaMalFormado;
import dominio.exceptions.ExceptionModeloMalFormado;

class TestAvion {

	@Test
	void testAvion_BienFormado() {
		try {
			Asiento asiento1 = new Asiento(1, "a1");
			Asiento asiento2 = new Asiento(1, "a2");
			ArrayList<Asiento> misAsientos = new ArrayList<Asiento>();
			misAsientos.add(asiento1);
			misAsientos.add(asiento2);
			Avion a1 = new Avion(1, "modelo", "matricula", misAsientos);
			assertEquals("ID: 1 - Modelo: modelo - Matricula: matricula - Asientos: A1, A2", a1.toString());
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
			assertEquals("Error en el modelo", e.getMessage());
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

	@Test
	void testAvionIdMalFormado() {
		try {
			ArrayList<Asiento> misAsientos = new ArrayList<Asiento>(); 
			Avion a1 = new Avion(-1, "modelo", "matricula", misAsientos);
			fail("Esta linea no deberia correrse");
		} catch (ExceptionIdMalFormado e) {
			assertEquals("Error en el Id.", e.getMessage());
		} catch (ExceptionGeneral e) {
			fail("Esta linea no deberia correrse.");
		} catch (Exception e) {
			fail("Esta linea no deberia correrse.");
		}
	}
}
