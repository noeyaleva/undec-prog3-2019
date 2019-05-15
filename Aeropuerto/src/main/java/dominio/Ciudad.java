package dominio;

import dominio.exceptions.ExceptionCodigoMalFormado;
import dominio.exceptions.ExceptionIdMalFormado;
import dominio.exceptions.ExceptionNombreMalFormado;

public class Ciudad {
	
	private int idCiudad;
	private String nombre;
	private String codigoPostal;
	
	public Ciudad(int idCiudad, String pNombre, String codigoPostal1) throws ExceptionIdMalFormado, ExceptionNombreMalFormado, ExceptionCodigoMalFormado{
		
		if(pNombre == "" || pNombre == null) {
			throw new ExceptionNombreMalFormado("Error en el nombre");
		}
		else {
			if(idCiudad < 1) {
				throw new ExceptionIdMalFormado("Error en el Id.");
			}
			else {
				if(codigoPostal1 == "" || codigoPostal1 == null) {
					throw new ExceptionCodigoMalFormado("Error en el codigo postal");
				}
				else {
					this.idCiudad = idCiudad;
					this.nombre = pNombre;
					this.codigoPostal = codigoPostal1;
				}
			}
		}
		
	}

	@Override
	public String toString() {
		//"ID: 1 - Nombre: Nonogasta - Codigo Postal: 5372."
		return "ID: " + this.idCiudad + " - Nombre: " + this.nombre + " - Codigo Postal: " + this.codigoPostal;
	}

	public int getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	

}
