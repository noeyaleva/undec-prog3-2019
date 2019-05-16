package dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dominio.exceptions.ExceptionGeneral;

public class GestorVuelo {
	
	private List<Vuelo> misVuelos = new ArrayList<Vuelo>();
	private static GestorVuelo gVuelo;
	
	public static GestorVuelo getInstancia() {
		if(gVuelo == null) {
			return gVuelo = new GestorVuelo();
		}
		return gVuelo;
	}

	public void limpiarVuelos() {
		 misVuelos = new ArrayList<Vuelo>();
	}

	public List<Vuelo> traerTodosVuelos() {
		List<Vuelo> misVuelo = new ArrayList<Vuelo>();
		
		for (Vuelo vuelo : misVuelos) {
			misVuelo.add(vuelo);
		}
		return misVuelo;
	}

	public boolean crearVuelo(String codigoVuelo, Aeropuerto salida, LocalDate fechaHoraSalida, Aeropuerto arribo, LocalDate fechaHoraArribo, Aerolinea aerolinea, List<Piloto> piloto, Avion avion, List<Asignacion> pasajeros) throws ExceptionGeneral{
		Vuelo vuelo = new Vuelo(codigoVuelo, salida, fechaHoraSalida, arribo, fechaHoraArribo, aerolinea, piloto, avion, pasajeros);
		misVuelos.add(vuelo);
		
		return true;
	}

	public Vuelo traerUnVuelo(String codigo) {

		for (Vuelo vuelo : misVuelos) {
			if(vuelo.getCodigoVuelo() == codigo) {
				return vuelo;
			}
		}
		return null;
	}

	public boolean BorrarVuelo(Vuelo vuelo1) {

		for (Vuelo vuelo : misVuelos) {
			if(vuelo.equals(vuelo1)) {
				misVuelos.remove(vuelo);
				return true;
			}
		}
		return false;
	}

	public Vuelo modificarVuelo(Vuelo vuelo, LocalDate fechaSalidaModificada) {

		for (Vuelo vuelo2 : misVuelos) {
			if(vuelo2.equals(vuelo)) {
				vuelo2.setFechaHoraSalida(fechaSalidaModificada);
				return vuelo2;
			}
		}
		return null;
	}

	public Vuelo traerVueloPorCriterip(Aerolinea aerolinea) {

		for (Vuelo vuelo : misVuelos) {
			if(vuelo.getAerolinea() == aerolinea) {
				return vuelo;
			}
		}
		return null;
	}
}
