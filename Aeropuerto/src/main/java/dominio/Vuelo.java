package dominio;

import java.time.LocalDate;
import java.util.List;

public class Vuelo {
	
	private String codigoVuelo;
	private Aeropuerto salida;
	private LocalDate fechaHoraSalida;
	private Aeropuerto arribo;
	private LocalDate fechaHoraArribo;
	private Aerolinea aerolinea;
	private List<Piloto> piloto;
	private Avion avion;
	private List<Asignacion> pasajeros;
	
	public Vuelo(String codigoVuelo, Aeropuerto salida, LocalDate fechaHoraSalida, Aeropuerto arribo,
			LocalDate fechaHoraArribo, Aerolinea aerolinea, List<Piloto> piloto, Avion avion,
			List<Asignacion> pasajeros) {
		this.codigoVuelo = codigoVuelo;
		this.salida = salida;
		this.fechaHoraSalida = fechaHoraSalida;
		this.arribo = arribo;
		this.fechaHoraArribo = fechaHoraArribo;
		this.aerolinea = aerolinea;
		this.piloto = piloto;
		this.avion = avion;
		this.pasajeros = pasajeros;
	}

	@Override
	public String toString() {
		//Vuelo: CodVuelo - Lugar Salida: Exeiza - FechaSalida: 01/03/1990 - Lugar Llegada: Cordoba - FechaArribo: 02/03/1990 - Aerolinea: Argentinas - Pilotos: 1, Nader, 2 Herrera - Cantidad Pasajeros: 4
		return "Vuelo: " + this.codigoVuelo + " - Lugar Salida: " + this.salida.getNombre() + " - FechaSalida: " + this.fechaHoraSalida + " - Lugar Llegada: " + this.arribo.getNombre() + " - FechaArribo: " + this.fechaHoraArribo 
				+ " - Aerolinea: " + this.aerolinea.getNombre() + " - Pilotos: " + this.piloto.get(0).getIdPiloto() + " " + this.piloto.get(0).getApellido() + ", " + this.piloto.get(1).getIdPiloto() + " " + this.piloto.get(1).getApellido() + " - Cantidad Pasajeros: " + this.pasajeros.size();
	}

}
