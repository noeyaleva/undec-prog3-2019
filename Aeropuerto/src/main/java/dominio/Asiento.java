package dominio;

import dominio.exceptions.ExceptionIdMalFormado;
import dominio.exceptions.ExceptionNumeroMalFormado;

public class Asiento {

	private int idAsiento;
	private String numeroAsiento;
	
	public Asiento(int aIdAsiento, String aNumeroAsiento) throws ExceptionIdMalFormado, ExceptionNumeroMalFormado {
		
		if(aIdAsiento < 1) {
			throw new ExceptionIdMalFormado("Error en el Id.");
		}
		else {
			if(aNumeroAsiento == "" || aNumeroAsiento == null) {
				throw new ExceptionNumeroMalFormado("Error en el numero de asiento");
			}
			else {
				this.idAsiento = aIdAsiento;
				this.numeroAsiento = aNumeroAsiento.toUpperCase();		
			}
		}
		
	}

	@Override
	public String toString() {
		//ID: 1 - N°: A1
		return "ID: " + this.idAsiento + " - N°: " + this.numeroAsiento;
	}
	
	public String getNumeroAsiento() {
		return this.numeroAsiento;
	}
	
}
