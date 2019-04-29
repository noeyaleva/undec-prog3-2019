package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPiloto {

	@Test
	void testPiloto_BienFormado() {
		try {
			Piloto p1 = new Piloto();
		}catch (ExceptionGeneral e) {
			fail("Esta línea no deberia Correrse");
		} catch (Exception e) {
			fail("Esta línea no deberia Correrse");
		}
	}
}
