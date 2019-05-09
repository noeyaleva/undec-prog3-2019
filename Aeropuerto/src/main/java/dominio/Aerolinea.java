package dominio;

import dominio.exceptions.ExceptionIdMalFormado;
import dominio.exceptions.ExceptionNombreMalFormado;

public class Aerolinea {

	private int IdAerolinea;
	private String nombre;
	
	public Aerolinea() {
		
	}

	public Aerolinea(int idAerolinea, String pNombre) throws ExceptionIdMalFormado, ExceptionNombreMalFormado{
		if(idAerolinea < 1) {
			throw new ExceptionIdMalFormado("Error en el Id.");
		}
		else {
			if(pNombre == "" || pNombre == null) {
				throw new ExceptionNombreMalFormado("Error en el nombre");
			}else {
				this.IdAerolinea = idAerolinea;
				this.nombre = pNombre;
			}
		}
		
	}

	@Override
	public String toString() {
		//ID: 1 - Nombre: Argentinas
		return "ID: " + this.IdAerolinea+ " - Nombre: " + this.nombre;
	}
	
	

}
