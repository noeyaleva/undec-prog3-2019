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

	public String getCodigoVuelo() {
		return codigoVuelo;
	}

	public void setCodigoVuelo(String codigoVuelo) {
		this.codigoVuelo = codigoVuelo;
	}

	public Aeropuerto getSalida() {
		return salida;
	}

	public void setSalida(Aeropuerto salida) {
		this.salida = salida;
	}

	public LocalDate getFechaHoraSalida() {
		return fechaHoraSalida;
	}

	public void setFechaHoraSalida(LocalDate fechaHoraSalida) {
		this.fechaHoraSalida = fechaHoraSalida;
	}

	public Aeropuerto getArribo() {
		return arribo;
	}

	public void setArribo(Aeropuerto arribo) {
		this.arribo = arribo;
	}

	public LocalDate getFechaHoraArribo() {
		return fechaHoraArribo;
	}

	public void setFechaHoraArribo(LocalDate fechaHoraArribo) {
		this.fechaHoraArribo = fechaHoraArribo;
	}

	public Aerolinea getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}

	public List<Piloto> getPiloto() {
		return piloto;
	}

	public void setPiloto(List<Piloto> piloto) {
		this.piloto = piloto;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public List<Asignacion> getPasajeros() {
		return pasajeros;
	}

	public void setPasajeros(List<Asignacion> pasajeros) {
		this.pasajeros = pasajeros;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoVuelo == null) ? 0 : codigoVuelo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vuelo other = (Vuelo) obj;
		if (codigoVuelo == null) {
			if (other.codigoVuelo != null)
				return false;
		} else if (!codigoVuelo.equals(other.codigoVuelo))
			return false;
		return true;
	}

	
}
