package dominio;

import dominio.exceptions.ExceptionCodigoMalFormado;
import dominio.exceptions.ExceptionIdMalFormado;
import dominio.exceptions.ExceptionNombreMalFormado;

public class Aeropuerto {
	
	private int idAeropuerto;
	private String nombre;
	private Ciudad ciudad;
	private String codigo;
	
	public Aeropuerto(int aIdAeropuerto, String aNombre, Ciudad aCiudad, String aCodigo) throws ExceptionIdMalFormado, ExceptionNombreMalFormado, ExceptionCodigoMalFormado {
	
		if(aIdAeropuerto < 1) {
			throw new ExceptionIdMalFormado("Error en el Id.");
		}
		else {
			if(aNombre == "" || aNombre == null) {
				throw new ExceptionNombreMalFormado("Error en el nombre");
			}
			else {
				if(aCodigo == "" || aCodigo == null) {
					throw new ExceptionCodigoMalFormado("Error en el codigo");
				}
				else {
					this.idAeropuerto = aIdAeropuerto;
					this.nombre = aNombre;
					this.ciudad = aCiudad;
					this.codigo = aCodigo;
				}
			}
		}
		
	}

	@Override
	public String toString() {
		//ID: 1 - Nombre: Exeiza - Ciudad: ID: 1 - Nombre: Nonogasta - Codigo Postal: 5372 - Codigo: 12345
		return "ID: " + this.idAeropuerto + " - Nombre: " + this.nombre + " - Ciudad: " + this.ciudad.toString() + " - Codigo: " + this.codigo; 
	}
	
	public String getNombre() {
		return this.nombre;
	}

}
