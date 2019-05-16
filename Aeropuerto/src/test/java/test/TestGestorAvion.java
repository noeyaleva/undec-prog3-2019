package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import dominio.Asiento;
import dominio.Avion;
import dominio.GestorAvion;
import dominio.exceptions.ExceptionGeneral;

class TestGestorAvion {

	@Test
	void testGestorAvionSingleton() {
		GestorAvion gAvion = GestorAvion.getInstancia();
		GestorAvion gAvion1 = GestorAvion.getInstancia();

		assertEquals(gAvion,gAvion1);
		assertEquals(true,gAvion.equals(gAvion1));
	}

	@Test
	void testGestorCrearAvion() {
		try {
			GestorAvion.getInstancia().limpiarAviones();
			Asiento asiento1 = new Asiento(1, "a1");
			Asiento asiento2 = new Asiento(2, "a2");
			Asiento asiento3 = new Asiento(3, "a3");
			Asiento asiento4 = new Asiento(4, "a4");
			Asiento asiento5 = new Asiento(5, "a5");
			Asiento asiento6 = new Asiento(6, "a6");
			Asiento asiento7 = new Asiento(7, "a7");
			Asiento asiento8 = new Asiento(8, "a8");
			ArrayList<Asiento> misAsientos = new ArrayList<Asiento>();
			misAsientos.add(asiento1);
			misAsientos.add(asiento2);
			misAsientos.add(asiento3);
			misAsientos.add(asiento4);
			misAsientos.add(asiento5);
			misAsientos.add(asiento6);
			misAsientos.add(asiento7);
			misAsientos.add(asiento8);
			
			Avion avion = new Avion(1, "modelo", "matricula", misAsientos);
			assertEquals(true, GestorAvion.getInstancia().crearAvion(avion.getIdAvion(), avion.getModelo(), avion.getMatricula(), avion.getListaAsientos()));
			assertEquals(true, avion.equals(GestorAvion.getInstancia().traerUno(avion.getIdAvion())));
		} catch(ExceptionGeneral e) {
			fail("Esta linea no deberia correrse");
		} catch(Exception e) {
			fail("Esta linea no deberia correrse");
		}
	}
	
	@Test
	void testGestorAvionBorrar() {
		try {
			GestorAvion.getInstancia().limpiarAviones();
			Asiento asiento1 = new Asiento(1, "a1");
			Asiento asiento2 = new Asiento(2, "a2");
			Asiento asiento3 = new Asiento(3, "a3");
			Asiento asiento4 = new Asiento(4, "a4");
			Asiento asiento5 = new Asiento(5, "a5");
			Asiento asiento6 = new Asiento(6, "a6");
			Asiento asiento7 = new Asiento(7, "a7");
			Asiento asiento8 = new Asiento(8, "a8");
			ArrayList<Asiento> misAsientos = new ArrayList<Asiento>();
			ArrayList<Asiento> misAsientos2 = new ArrayList<Asiento>();
			misAsientos.add(asiento1);
			misAsientos.add(asiento2);
			misAsientos.add(asiento3);
			misAsientos.add(asiento4);
			misAsientos2.add(asiento5);
			misAsientos2.add(asiento6);
			misAsientos2.add(asiento7);
			misAsientos2.add(asiento8);
			
			Avion avion = new Avion(1, "modelo", "matricula", misAsientos);
			Avion avion1 = new Avion(2, "kj", "123mk", misAsientos2);
			assertEquals(true, GestorAvion.getInstancia().crearAvion(avion.getIdAvion(), avion.getModelo(), avion.getMatricula(), avion.getListaAsientos()));
			assertEquals(true, GestorAvion.getInstancia().crearAvion(avion1.getIdAvion(), avion1.getModelo(), avion1.getMatricula(), avion1.getListaAsientos()));
			assertEquals(false, avion1.equals(GestorAvion.getInstancia().traerUno(avion.getIdAvion())));
			assertEquals(2,GestorAvion.getInstancia().traerTodosAviones().size());
			assertEquals(true, GestorAvion.getInstancia().BorrarAvion(avion1));
			assertEquals(1,GestorAvion.getInstancia().traerTodosAviones().size());

		} catch(ExceptionGeneral e) {
			fail("Esta linea no deberia correrse");
		} catch(Exception e) {
			fail("Esta linea no deberia correrse");
		}
	}
	
	@Test
	void testGestorAvionModificar() {
		try {
			GestorAvion.getInstancia().limpiarAviones();
			Asiento asiento1 = new Asiento(1, "a1");
			Asiento asiento2 = new Asiento(2, "a2");
			Asiento asiento3 = new Asiento(3, "a3");
			Asiento asiento4 = new Asiento(4, "a4");
			Asiento asiento5 = new Asiento(5, "a5");
			Asiento asiento6 = new Asiento(6, "a6");
			Asiento asiento7 = new Asiento(7, "a7");
			Asiento asiento8 = new Asiento(8, "a8");
			ArrayList<Asiento> misAsientos = new ArrayList<Asiento>();
			ArrayList<Asiento> misAsientos2 = new ArrayList<Asiento>();
			misAsientos.add(asiento1);
			misAsientos.add(asiento2);
			misAsientos.add(asiento3);
			misAsientos.add(asiento4);
			misAsientos2.add(asiento5);
			misAsientos2.add(asiento6);
			misAsientos2.add(asiento7);
			misAsientos2.add(asiento8);
			
			Avion avion = new Avion(1, "modelo", "matricula", misAsientos);
			Avion avion1 = new Avion(2, "kj", "123mk", misAsientos2);
			
			assertEquals(true, GestorAvion.getInstancia().crearAvion(avion.getIdAvion(), avion.getModelo(), avion.getMatricula(), avion.getListaAsientos()));
			assertEquals(true, GestorAvion.getInstancia().crearAvion(avion1.getIdAvion(), avion1.getModelo(), avion1.getMatricula(), avion1.getListaAsientos()));
			assertEquals(false, avion1.equals(GestorAvion.getInstancia().traerUno(avion.getIdAvion())));
			assertEquals(2,GestorAvion.getInstancia().traerTodosAviones().size());
			avion1.setMatricula("matriculaNueva");
			assertEquals(true, avion1.equals(GestorAvion.getInstancia().ModificarAvion(avion1, "matriculaNueva")));
			assertEquals(2,GestorAvion.getInstancia().traerTodosAviones().size());

		} catch(ExceptionGeneral e) {
			fail("Esta linea no deberia correrse");
		} catch(Exception e) {
			fail("Esta linea no deberia correrse");
		}
	}
	
	@Test
	void testGestorAvionPorCriterio() {
		try {
			GestorAvion.getInstancia().limpiarAviones();
			Asiento asiento1 = new Asiento(1, "a1");
			Asiento asiento2 = new Asiento(2, "a2");
			Asiento asiento3 = new Asiento(3, "a3");
			Asiento asiento4 = new Asiento(4, "a4");
			Asiento asiento5 = new Asiento(5, "a5");
			Asiento asiento6 = new Asiento(6, "a6");
			Asiento asiento7 = new Asiento(7, "a7");
			Asiento asiento8 = new Asiento(8, "a8");
			ArrayList<Asiento> misAsientos = new ArrayList<Asiento>();
			ArrayList<Asiento> misAsientos2 = new ArrayList<Asiento>();
			misAsientos.add(asiento1);
			misAsientos.add(asiento2);
			misAsientos.add(asiento3);
			misAsientos.add(asiento4);
			misAsientos2.add(asiento5);
			misAsientos2.add(asiento6);
			misAsientos2.add(asiento7); 
			misAsientos2.add(asiento8);
			
			Avion avion = new Avion(1, "modelo", "matricula", misAsientos);
			Avion avion1 = new Avion(2, "kj", "123mk", misAsientos2);
			assertEquals(true, GestorAvion.getInstancia().crearAvion(avion.getIdAvion(), avion.getModelo(), avion.getMatricula(), avion.getListaAsientos()));
			assertEquals(true, GestorAvion.getInstancia().crearAvion(avion1.getIdAvion(), avion1.getModelo(), avion1.getMatricula(), avion1.getListaAsientos()));
			assertEquals(false, avion.equals(GestorAvion.getInstancia().traerUno(avion1.getIdAvion())));
			assertEquals(true,avion.equals(GestorAvion.getInstancia().traerUno(avion.getIdAvion())));
			assertEquals(true,avion.equals(GestorAvion.getInstancia().traerPorCriterio(avion.getModelo())));
			assertEquals(false,avion1.equals(GestorAvion.getInstancia().traerPorCriterio(avion.getModelo())));
			
		} catch(ExceptionGeneral e) {
			fail("Esta linea no deberia correrse");
		} catch(Exception e) {
			fail("Esta linea no deberia correrse");
		}
	}
}
