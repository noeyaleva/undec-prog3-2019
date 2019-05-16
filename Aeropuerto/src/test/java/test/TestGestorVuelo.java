package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import dominio.Aerolinea;
import dominio.Aeropuerto;
import dominio.Asiento;
import dominio.Asignacion;
import dominio.Avion;
import dominio.Ciudad;
import dominio.GestorVuelo;
import dominio.Pasajero;
import dominio.Piloto;
import dominio.Vuelo;
import dominio.exceptions.ExceptionGeneral;

class TestGestorVuelo {

	@Test
	void testGestorVueloSingleton() {
		GestorVuelo gVuelo1 = GestorVuelo.getInstancia();
		GestorVuelo gVuelo2 = GestorVuelo.getInstancia();
		
		assertEquals(gVuelo1,gVuelo2);
		assertEquals(true,gVuelo1.equals(gVuelo2));
	}
	
	@Test
	void testGestorVueloVacio() {
		GestorVuelo.getInstancia().limpiarVuelos();
		assertEquals(0,GestorVuelo.getInstancia().traerTodosVuelos().size());
	}

	@Test
	void testGestorVueloCrear() {
		try {
			GestorVuelo.getInstancia().limpiarVuelos();
			Ciudad ciudad = new Ciudad(1, "Nonogasta", "5372");
			Ciudad ciudad1 = new Ciudad(1, "Cordoba", "5462");
			
			Aeropuerto salida = new Aeropuerto(1, "Exeiza", ciudad, "12345");
			Aeropuerto arribo = new Aeropuerto(1, "Cordoba", ciudad1, "12345");
			
			LocalDate fechaSalida = LocalDate.of(1990,3,1);
			LocalDate fechaArribo = LocalDate.of(1990,3,2);
			
			Aerolinea aerolinea = new Aerolinea(1, "Argentinas");
			
			LocalDate fechaNacimiento = LocalDate.of(1970,5,1);
			LocalDate fechaNacimiento1 = LocalDate.of(1960,9,1);
			Piloto piloto = new Piloto(1, "Nader", "Enrique", "12345678", fechaNacimiento);
			Piloto piloto1 = new Piloto(2, "Herrera", "Enrique", "98765432", fechaNacimiento1);
			List<Piloto> pilotos = new ArrayList<Piloto>();
			pilotos.add(piloto);
			pilotos.add(piloto1);
			
			Asiento asiento1 = new Asiento(1, "a1");
			Asiento asiento2 = new Asiento(1, "a2");
			Asiento asiento3 = new Asiento(1, "a3");
			Asiento asiento4 = new Asiento(1, "b1");
			Asiento asiento5 = new Asiento(1, "b2");
			Asiento asiento6 = new Asiento(1, "b3");
			List<Asiento> misAsientos;
			misAsientos = new ArrayList<Asiento>();
			misAsientos.add(asiento1);
			misAsientos.add(asiento2);
			Avion avion = new Avion(1, "modelo", "matricula", misAsientos);
			
			Pasajero p1 = new Pasajero(1, "1234456", "lopez", "Javier", "03825123345");
			Pasajero p2 = new Pasajero(2, "1234456", "gomez", "hugo", "03825123345");
			Pasajero p3 = new Pasajero(3, "1234456", "messi", "nestor", "03825123345");
			Pasajero p4 = new Pasajero(4, "1234456", "ramos", "nicolas", "03825123345");
			Pasajero p5 = new Pasajero(5, "1234456", "pique", "nano", "03825123345");
			
			Asignacion asignacion1 = new Asignacion(p1, asiento1, "1");
			Asignacion asignacion2 = new Asignacion(p2, asiento2, "2");
			Asignacion asignacion3 = new Asignacion(p3, asiento3, "3");
			Asignacion asignacion4 = new Asignacion(p4, asiento4, "4");
			List<Asignacion> pasajeros = new ArrayList<Asignacion>();
			
			pasajeros.add(asignacion1);
			pasajeros.add(asignacion2);
			pasajeros.add(asignacion3);
			pasajeros.add(asignacion4);
			
			Vuelo vuelo = new Vuelo("CodVuelo", salida, fechaSalida, arribo, fechaArribo, aerolinea, pilotos, avion, pasajeros);
			
			assertEquals(true, GestorVuelo.getInstancia().crearVuelo(vuelo.getCodigoVuelo(), vuelo.getSalida(), vuelo.getFechaHoraSalida(), vuelo.getArribo(), vuelo.getFechaHoraArribo(), vuelo.getAerolinea(), vuelo.getPiloto(), vuelo.getAvion(), vuelo.getPasajeros()));
			assertEquals(1,GestorVuelo.getInstancia().traerTodosVuelos().size());
			Vuelo vuelo1 = GestorVuelo.getInstancia().traerUnVuelo("CodVuelo");
			assertEquals(true, vuelo.equals(vuelo1));
			
		} catch (ExceptionGeneral ex) {
			fail("Esta linea no deberia correrse");
			
		} catch (Exception ex) {
			fail("Esta linea no deberia correrse");
			
		}
		
		
	}
	
	@Test
	void testGestorVueloBorrar() {
		try {
			GestorVuelo.getInstancia().limpiarVuelos();
			Ciudad ciudad = new Ciudad(1, "Nonogasta", "5372");
			Ciudad ciudad1 = new Ciudad(1, "Cordoba", "5462");
			
			Aeropuerto salida = new Aeropuerto(1, "Exeiza", ciudad, "12345");
			Aeropuerto arribo = new Aeropuerto(1, "Cordoba", ciudad1, "12345");
			
			LocalDate fechaSalida = LocalDate.of(1990,3,1);
			LocalDate fechaArribo = LocalDate.of(1990,3,2);
			
			Aerolinea aerolinea = new Aerolinea(1, "Argentinas");
			
			LocalDate fechaNacimiento = LocalDate.of(1970,5,1);
			LocalDate fechaNacimiento1 = LocalDate.of(1960,9,1);
			Piloto piloto = new Piloto(1, "Nader", "Enrique", "12345678", fechaNacimiento);
			Piloto piloto1 = new Piloto(2, "Herrera", "Enrique", "98765432", fechaNacimiento1);
			List<Piloto> pilotos = new ArrayList<Piloto>();
			pilotos.add(piloto);
			pilotos.add(piloto1);
			
			Asiento asiento1 = new Asiento(1, "a1");
			Asiento asiento2 = new Asiento(1, "a2");
			Asiento asiento3 = new Asiento(1, "a3");
			Asiento asiento4 = new Asiento(1, "b1");
			Asiento asiento5 = new Asiento(1, "b2");
			Asiento asiento6 = new Asiento(1, "b3");
			List<Asiento> misAsientos;
			misAsientos = new ArrayList<Asiento>();
			misAsientos.add(asiento1);
			misAsientos.add(asiento2);
			Avion avion = new Avion(1, "modelo", "matricula", misAsientos);
			
			Pasajero p1 = new Pasajero(1, "1234456", "lopez", "Javier", "03825123345");
			Pasajero p2 = new Pasajero(2, "1234456", "gomez", "hugo", "03825123345");
			Pasajero p3 = new Pasajero(3, "1234456", "messi", "nestor", "03825123345");
			Pasajero p4 = new Pasajero(4, "1234456", "ramos", "nicolas", "03825123345");
			Pasajero p5 = new Pasajero(5, "1234456", "pique", "nano", "03825123345");
			
			Asignacion asignacion1 = new Asignacion(p1, asiento1, "1");
			Asignacion asignacion2 = new Asignacion(p2, asiento2, "2");
			Asignacion asignacion3 = new Asignacion(p3, asiento3, "3");
			Asignacion asignacion4 = new Asignacion(p4, asiento4, "4");
			List<Asignacion> pasajeros = new ArrayList<Asignacion>();
			
			pasajeros.add(asignacion1);
			pasajeros.add(asignacion2);
			pasajeros.add(asignacion3);
			pasajeros.add(asignacion4);
			
			Vuelo vuelo = new Vuelo("CodVuelo", salida, fechaSalida, arribo, fechaArribo, aerolinea, pilotos, avion, pasajeros);
			
			Ciudad ciudadv1 = new Ciudad(11, "Mendoza", "5372");
			Ciudad ciudadv2 = new Ciudad(10, "Neuquen", "5462");
			
			Aeropuerto salidav = new Aeropuerto(110, "Viñas", ciudadv1, "12345");
			Aeropuerto arribov = new Aeropuerto(101, "Huapi", ciudadv2, "12345");
			
			LocalDate fechaNacimientov = LocalDate.of(1970,5,1);
			LocalDate fechaNacimientov1 = LocalDate.of(1960,9,1);
			Piloto pilotov = new Piloto(1, "Soria", "Adan", "12345678", fechaNacimientov);
			Piloto pilotov1 = new Piloto(2, "Diaz", "Samuel", "98765432", fechaNacimientov1);
			List<Piloto> pilotos2 = new ArrayList<Piloto>();
			pilotos2.add(pilotov);
			pilotos2.add(pilotov1);
							
			Avion avion1 = new Avion(1001, "modelo", "matricula", misAsientos);
			
			Vuelo vuelo1 = new Vuelo("CodVuelo1", salida, fechaSalida, arribo, fechaArribo, aerolinea, pilotos2, avion1, pasajeros);
			
			assertEquals(true, GestorVuelo.getInstancia().crearVuelo(vuelo.getCodigoVuelo(), vuelo.getSalida(), vuelo.getFechaHoraSalida(), vuelo.getArribo(), vuelo.getFechaHoraArribo(), vuelo.getAerolinea(), vuelo.getPiloto(), vuelo.getAvion(), vuelo.getPasajeros()));
			assertEquals(true, GestorVuelo.getInstancia().crearVuelo(vuelo1.getCodigoVuelo(), vuelo1.getSalida(), vuelo1.getFechaHoraSalida(), vuelo1.getArribo(), vuelo1.getFechaHoraArribo(), vuelo1.getAerolinea(), vuelo1.getPiloto(), vuelo1.getAvion(), vuelo1.getPasajeros()));
			assertEquals(2,GestorVuelo.getInstancia().traerTodosVuelos().size());
			assertEquals(true, GestorVuelo.getInstancia().BorrarVuelo(vuelo));
			assertEquals(1,GestorVuelo.getInstancia().traerTodosVuelos().size());
			
		} catch (ExceptionGeneral ex) {
			fail("Esta linea no deberia correrse");
			
		} catch (Exception ex) {
			fail("Esta linea no deberia correrse");
			
		}
	}
	
	@Test
	void testGestorModificarVuelo() {
		try {
			GestorVuelo.getInstancia().limpiarVuelos();
			Ciudad ciudad = new Ciudad(1, "Nonogasta", "5372");
			Ciudad ciudad1 = new Ciudad(1, "Cordoba", "5462");
			
			Aeropuerto salida = new Aeropuerto(1, "Exeiza", ciudad, "12345");
			Aeropuerto arribo = new Aeropuerto(1, "Cordoba", ciudad1, "12345");
			
			LocalDate fechaSalida = LocalDate.of(1990,3,1);
			LocalDate fechaArribo = LocalDate.of(1990,3,2);
			
			Aerolinea aerolinea = new Aerolinea(1, "Argentinas");
			
			LocalDate fechaNacimiento = LocalDate.of(1970,5,1);
			LocalDate fechaNacimiento1 = LocalDate.of(1960,9,1);
			Piloto piloto = new Piloto(1, "Nader", "Enrique", "12345678", fechaNacimiento);
			Piloto piloto1 = new Piloto(2, "Herrera", "Enrique", "98765432", fechaNacimiento1);
			List<Piloto> pilotos = new ArrayList<Piloto>();
			pilotos.add(piloto);
			pilotos.add(piloto1);
			
			Asiento asiento1 = new Asiento(1, "a1");
			Asiento asiento2 = new Asiento(1, "a2");
			Asiento asiento3 = new Asiento(1, "a3");
			Asiento asiento4 = new Asiento(1, "b1");
			Asiento asiento5 = new Asiento(1, "b2");
			Asiento asiento6 = new Asiento(1, "b3");
			List<Asiento> misAsientos;
			misAsientos = new ArrayList<Asiento>();
			misAsientos.add(asiento1);
			misAsientos.add(asiento2);
			Avion avion = new Avion(1, "modelo", "matricula", misAsientos);
			
			Pasajero p1 = new Pasajero(1, "1234456", "lopez", "Javier", "03825123345");
			Pasajero p2 = new Pasajero(2, "1234456", "gomez", "hugo", "03825123345");
			Pasajero p3 = new Pasajero(3, "1234456", "messi", "nestor", "03825123345");
			Pasajero p4 = new Pasajero(4, "1234456", "ramos", "nicolas", "03825123345");
			Pasajero p5 = new Pasajero(5, "1234456", "pique", "nano", "03825123345");
			
			Asignacion asignacion1 = new Asignacion(p1, asiento1, "1");
			Asignacion asignacion2 = new Asignacion(p2, asiento2, "2");
			Asignacion asignacion3 = new Asignacion(p3, asiento3, "3");
			Asignacion asignacion4 = new Asignacion(p4, asiento4, "4");
			List<Asignacion> pasajeros = new ArrayList<Asignacion>();
			
			pasajeros.add(asignacion1);
			pasajeros.add(asignacion2);
			pasajeros.add(asignacion3);
			pasajeros.add(asignacion4);
			
			Vuelo vuelo = new Vuelo("CodVuelo", salida, fechaSalida, arribo, fechaArribo, aerolinea, pilotos, avion, pasajeros);
			
			Ciudad ciudadv1 = new Ciudad(11, "Mendoza", "5372");
			Ciudad ciudadv2 = new Ciudad(10, "Neuquen", "5462");
			
			Aeropuerto salidav = new Aeropuerto(110, "Viñas", ciudadv1, "12345");
			Aeropuerto arribov = new Aeropuerto(101, "Huapi", ciudadv2, "12345");
			
			LocalDate fechaNacimientov = LocalDate.of(1970,5,1);
			LocalDate fechaNacimientov1 = LocalDate.of(1960,9,1);
			Piloto pilotov = new Piloto(1, "Soria", "Adan", "12345678", fechaNacimientov);
			Piloto pilotov1 = new Piloto(2, "Diaz", "Samuel", "98765432", fechaNacimientov1);
			List<Piloto> pilotos2 = new ArrayList<Piloto>();
			pilotos2.add(pilotov);
			pilotos2.add(pilotov1);
							
			Avion avion1 = new Avion(1001, "modelo", "matricula", misAsientos);
			
			LocalDate fechaSalidaModificada = LocalDate.of(1990,3,3);
			
			Vuelo vuelo1 = new Vuelo("CodVuelo1", salida, fechaSalida, arribo, fechaArribo, aerolinea, pilotos2, avion1, pasajeros);
			
			assertEquals(true, GestorVuelo.getInstancia().crearVuelo(vuelo.getCodigoVuelo(), vuelo.getSalida(), vuelo.getFechaHoraSalida(), vuelo.getArribo(), vuelo.getFechaHoraArribo(), vuelo.getAerolinea(), vuelo.getPiloto(), vuelo.getAvion(), vuelo.getPasajeros()));
			assertEquals(true, GestorVuelo.getInstancia().crearVuelo(vuelo1.getCodigoVuelo(), vuelo1.getSalida(), vuelo1.getFechaHoraSalida(), vuelo1.getArribo(), vuelo1.getFechaHoraArribo(), vuelo1.getAerolinea(), vuelo1.getPiloto(), vuelo1.getAvion(), vuelo1.getPasajeros()));
			assertEquals(2,GestorVuelo.getInstancia().traerTodosVuelos().size());
			assertEquals(false, vuelo.getFechaHoraSalida() == GestorVuelo.getInstancia().modificarVuelo(vuelo, fechaSalidaModificada).getFechaHoraSalida());
			vuelo.setFechaHoraSalida(fechaSalidaModificada);
			assertEquals(true, vuelo.getFechaHoraSalida() == GestorVuelo.getInstancia().modificarVuelo(vuelo, fechaSalidaModificada).getFechaHoraSalida());
			assertEquals(2,GestorVuelo.getInstancia().traerTodosVuelos().size());
			assertEquals("Vuelo: CodVuelo - Lugar Salida: Exeiza - FechaSalida: 1990-03-03 - Lugar Llegada: Cordoba - FechaArribo: 1990-03-02 - Aerolinea: Argentinas - Pilotos: 1 Nader, 2 Herrera - Cantidad Pasajeros: 4",vuelo.toString());
			
		} catch (ExceptionGeneral ex) {
			fail("Esta linea no deberia correrse");
			
		} catch (Exception ex) {
			fail("Esta linea no deberia correrse");
			
		}
	}
	
	@Test
	void testGestorVueloPorCriterio() {
		try {
			GestorVuelo.getInstancia().limpiarVuelos();
			Ciudad ciudad = new Ciudad(1, "Nonogasta", "5372");
			Ciudad ciudad1 = new Ciudad(1, "Cordoba", "5462");
			
			Aeropuerto salida = new Aeropuerto(1, "Exeiza", ciudad, "12345");
			Aeropuerto arribo = new Aeropuerto(1, "Cordoba", ciudad1, "12345");
			
			LocalDate fechaSalida = LocalDate.of(1990,3,1);
			LocalDate fechaArribo = LocalDate.of(1990,3,2);
			
			Aerolinea aerolinea = new Aerolinea(1, "Argentinas");
			
			LocalDate fechaNacimiento = LocalDate.of(1970,5,1);
			LocalDate fechaNacimiento1 = LocalDate.of(1960,9,1);
			Piloto piloto = new Piloto(1, "Nader", "Enrique", "12345678", fechaNacimiento);
			Piloto piloto1 = new Piloto(2, "Herrera", "Enrique", "98765432", fechaNacimiento1);
			List<Piloto> pilotos = new ArrayList<Piloto>();
			pilotos.add(piloto);
			pilotos.add(piloto1);
			
			Asiento asiento1 = new Asiento(1, "a1");
			Asiento asiento2 = new Asiento(1, "a2");
			Asiento asiento3 = new Asiento(1, "a3");
			Asiento asiento4 = new Asiento(1, "b1");
			Asiento asiento5 = new Asiento(1, "b2");
			Asiento asiento6 = new Asiento(1, "b3");
			List<Asiento> misAsientos;
			misAsientos = new ArrayList<Asiento>();
			misAsientos.add(asiento1);
			misAsientos.add(asiento2);
			Avion avion = new Avion(1, "modelo", "matricula", misAsientos);
			
			Pasajero p1 = new Pasajero(1, "1234456", "lopez", "Javier", "03825123345");
			Pasajero p2 = new Pasajero(2, "1234456", "gomez", "hugo", "03825123345");
			Pasajero p3 = new Pasajero(3, "1234456", "messi", "nestor", "03825123345");
			Pasajero p4 = new Pasajero(4, "1234456", "ramos", "nicolas", "03825123345");
			Pasajero p5 = new Pasajero(5, "1234456", "pique", "nano", "03825123345");
			
			Asignacion asignacion1 = new Asignacion(p1, asiento1, "1");
			Asignacion asignacion2 = new Asignacion(p2, asiento2, "2");
			Asignacion asignacion3 = new Asignacion(p3, asiento3, "3");
			Asignacion asignacion4 = new Asignacion(p4, asiento4, "4");
			List<Asignacion> pasajeros = new ArrayList<Asignacion>();
			
			pasajeros.add(asignacion1);
			pasajeros.add(asignacion2);
			pasajeros.add(asignacion3);
			pasajeros.add(asignacion4);
			
			Vuelo vuelo = new Vuelo("CodVuelo", salida, fechaSalida, arribo, fechaArribo, aerolinea, pilotos, avion, pasajeros);
			
			Ciudad ciudadv1 = new Ciudad(11, "Mendoza", "5372");
			Ciudad ciudadv2 = new Ciudad(10, "Neuquen", "5462");
			
			Aeropuerto salidav = new Aeropuerto(110, "Viñas", ciudadv1, "12345");
			Aeropuerto arribov = new Aeropuerto(101, "Huapi", ciudadv2, "12345");
			
			LocalDate fechaNacimientov = LocalDate.of(1970,5,1);
			LocalDate fechaNacimientov1 = LocalDate.of(1960,9,1);
			Piloto pilotov = new Piloto(1, "Soria", "Adan", "12345678", fechaNacimientov);
			Piloto pilotov1 = new Piloto(2, "Diaz", "Samuel", "98765432", fechaNacimientov1);
			List<Piloto> pilotos2 = new ArrayList<Piloto>();
			pilotos2.add(pilotov);
			pilotos2.add(pilotov1);
							
			Avion avion1 = new Avion(1001, "modelo", "matricula", misAsientos);
			
			Vuelo vuelo1 = new Vuelo("CodVuelo1", salida, fechaSalida, arribo, fechaArribo, aerolinea, pilotos2, avion1, pasajeros);
			
			assertEquals(true, GestorVuelo.getInstancia().crearVuelo(vuelo.getCodigoVuelo(), vuelo.getSalida(), vuelo.getFechaHoraSalida(), vuelo.getArribo(), vuelo.getFechaHoraArribo(), vuelo.getAerolinea(), vuelo.getPiloto(), vuelo.getAvion(), vuelo.getPasajeros()));
			assertEquals(true, GestorVuelo.getInstancia().crearVuelo(vuelo1.getCodigoVuelo(), vuelo1.getSalida(), vuelo1.getFechaHoraSalida(), vuelo1.getArribo(), vuelo1.getFechaHoraArribo(), vuelo1.getAerolinea(), vuelo1.getPiloto(), vuelo1.getAvion(), vuelo1.getPasajeros()));
			assertEquals(true,vuelo.equals(GestorVuelo.getInstancia().traerVueloPorCriterip(aerolinea)));
			assertEquals("Vuelo: CodVuelo - Lugar Salida: Exeiza - FechaSalida: 1990-03-01 - Lugar Llegada: Cordoba - FechaArribo: 1990-03-02 - Aerolinea: Argentinas - Pilotos: 1 Nader, 2 Herrera - Cantidad Pasajeros: 4",vuelo.toString());
			
		} catch (ExceptionGeneral ex) {
			fail("Esta linea no deberia correrse");
			
		} catch (Exception ex) {
			fail("Esta linea no deberia correrse");
			
		}
	}
}
