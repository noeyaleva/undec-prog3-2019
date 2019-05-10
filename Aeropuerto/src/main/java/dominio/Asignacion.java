package dominio;

import dominio.exceptions.ExceptionCodigoMalFormado;

public class Asignacion {

	private Pasajero pasajero;
	private Asiento asiento;
	private String codigoAsignacion;
	
	public Asignacion(Pasajero pasajero, Asiento asiento, String codigoAsignacion) throws ExceptionCodigoMalFormado {
	
		if(codigoAsignacion == "" || codigoAsignacion == null) {
			throw new ExceptionCodigoMalFormado("Error en el codigo");
		}
		else {
			this.pasajero = pasajero;
			this.asiento = asiento;
			this.codigoAsignacion = codigoAsignacion;	
		}
	}

	@Override
	public String toString() {
		//ID Pasajero: 1 - Asiento: A1 - Codigo: Codigo
		return "ID Pasajero: " + this.pasajero.getIdPasajero() + " - Asiento: " + this.asiento.getNumeroAsiento() + " - Codigo: " + this.codigoAsignacion;
	}
	
	
}
