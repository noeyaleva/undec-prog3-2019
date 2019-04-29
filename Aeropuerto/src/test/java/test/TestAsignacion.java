package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestAsignacion {

	@Test
	void testAsignacion_BienFormada() {
		try {
			Pasajero p1 = new Pasajero(1, "1234456", "lopez", "Javier", "03825123345");
			Asiento asiento = new Asiento(1, "A1");
			Asignacion a1 = new Asignacion(p1, asiento, "codigo");
			assertEquals("Id Pasajero: 1 - Asiento: A1 - Codigo: Codigo", a1.toString());
		} catch (ExceptionGeneral e) {
			fail("Esta línea no deberia Correrse");
		} catch (Exception e) {
			fail("Esta línea no deberia Correrse");
		}
	}
	
	@Test
	void testAsignacionCodigoMalFormado() {
		try {
			Pasajero p1 = new Pasajero(1, "1234456", "lopez", "Javier", "03825123345");
			Asiento asiento = new Asiento(1, "A1");
			Asignacion a1 = new Asignacion(p1, asiento, "");
			fail("Esta linea no deberia correrse");
			
		} catch(ExceptionCodigoMalFormado e) {
			assertEquals("Error en el codigo", e.getMessage());
		} catch(ExceptionGeneral e) {
			fail("Esta linea no deberia correrse");
		} catch(Exception e) {
			fail("Esta linea no deberia correrse");
		}
		
		try {
			Pasajero p1 = new Pasajero(1, "1234456", "lopez", "Javier", "03825123345");
			Asiento asiento = new Asiento(1, "A1");
			Asignacion a1 = new Asignacion(p1, asiento, null);
			fail("Esta linea no deberia correrse");
		} catch(ExceptionCodigoMalFormado e) {
			assertEquals("Error en el codigo", e.getMessage());
		} catch(ExceptionGeneral e) {
			fail("Esta linea no deberia correrse");
		} catch(Exception e) {
			fail("Esta linea no deberia correrse");
		}
	}

}
