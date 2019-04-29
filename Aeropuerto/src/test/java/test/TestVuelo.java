package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TestVuelo {

	@Test
	void testVuelo_BienFormado() {
		try {
			Cuidad ciudad = new Ciudad(1, "Nonogasta", "5372");
			Cuidad ciudad1 = new Ciudad(1, "Cordoba", "5462");
			
			Aeropuerto salida = new Aeropuerto(1, "Exeiza", ciudad, "12345");
			Aeropuerto arribo = new Aeropuerto(1, "Cordoba", ciudad1, "12345");
			
			LocalDate fechaSalida = new LocalDate(1,3,1990);
			LocalDate fechaArribo = new LocalDate(2,3,1990);
			
			Aerolinea aerolinea = new Aerolinea(1, "Argentinas");
			
			LocalDate fechaNacimiento = new LocalDate(5,11,1990);
			LocalDate fechaNacimiento1 = new LocalDate(1,3,1990);
			Piloto piloto = new Piloto(1, "Nader", "Enrique", "12345678", fechaNacimiento);
			Piloto piloto1 = new Piloto(2, "Herrera", "Enrique", "98765432", fechaNacimiento1);
			ArrayList<Piloto> pilotos = new ArrayList<Piloto>();
			pilotos.add(piloto);
			pilotos.add(piloto1);
			
			ArrayList<Asiento> misAsientos = new ArrayList<Asiento>(); 
			Avion avion = new Avion(1, "modelo", "matricula", misAsientos);
			
			Pasajero p1 = new Pasajero(1, "1234456", "lopez", "Javier", "03825123345");
			Pasajero p2 = new Pasajero(2, "1234456", "gomez", "hugo", "03825123345");
			Pasajero p3 = new Pasajero(3, "1234456", "messi", "nestor", "03825123345");
			Pasajero p4 = new Pasajero(4, "1234456", "ramos", "nicolas", "03825123345");
			Pasajero p5 = new Pasajero(5, "1234456", "pique", "nano", "03825123345");
			ArrayList<Pasajero> pasajeros = new ArrayList<Pasajero>();
			
			pasajeros.add(p1);
			pasajeros.add(p2);
			pasajeros.add(p3);
			pasajeros.add(p4);
			pasajeros.add(p5);
			
			Vuelo vuelo = new Vuelo("CodVuelo", salida, fechaSalida, arribo, fechaArribo, aerolinea, pilotos, avion, pasajeros);
			asserEquals("Vuelo: CodVuelo - Lugar Salida: Exeiza - FechaSalida: 1/3/1990 - Lugar Llegada: Cordoba - FechaArribo: 2/3/1990 - Aerolinea: Argentinas - Pilotos: 1, Nader, 2 Herrera - Cantidad Pasajeros: 5",vuelo.toString());
		} catch (ExceptionGeneral e) {
			fail("Esta línea no deberia Correrse");
		} catch (Exception e) {
			fail("Esta línea no deberia Correrse");
		}
	}

}
