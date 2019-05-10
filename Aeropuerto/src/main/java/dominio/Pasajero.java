package dominio;

import dominio.exceptions.ExceptionApellidoMalFormado;
import dominio.exceptions.ExceptionCuilMalFormado;
import dominio.exceptions.ExceptionIdMalFormado;
import dominio.exceptions.ExceptionNombreMalFormado;
import dominio.exceptions.ExceptionTelefonoMalFormado;

public class Pasajero {
	
	private int idPasajero;
	private String cuil;
	private String apellido;
	private String nombre;
	private String telefono;
	
	public Pasajero(int pIdPasajero, String pCuil, String pApellido, String pNombre, String pTelefono) throws ExceptionIdMalFormado, ExceptionNombreMalFormado, ExceptionApellidoMalFormado, ExceptionCuilMalFormado, ExceptionTelefonoMalFormado {
		
		if(pIdPasajero < 1) {
			throw new ExceptionIdMalFormado("Error en el Id.");
		}
		else {
			if(pCuil == "" || pCuil == null) {
				throw new ExceptionCuilMalFormado("Error en el cuil");
			}
			else {
				if(pApellido == "" || pApellido == null) {
					throw new ExceptionApellidoMalFormado("Error en el apellido");
				}
				else {
					if(pNombre == "" || pNombre == null) {
						throw new ExceptionNombreMalFormado("Error en el nombre");
					}
					else {
						if(pTelefono == "" || pTelefono == null) {
							throw new ExceptionTelefonoMalFormado("Error en el telefono");
						}
						else {
							this.idPasajero = pIdPasajero;
							this.cuil = pCuil;
							this.apellido = pApellido.substring(0,1).toUpperCase() + pApellido.substring(1);
							this.nombre = pNombre.substring(0,1).toUpperCase() + pNombre.substring(1);
							this.telefono = pTelefono;
						}
					}
				}
			}
		}
		
	}

	@Override
	public String toString() {
		//ID: 1 - Apellido y Nombre: Lopez, Javier - Tel: 03825123345
		return "ID: " + this.idPasajero + " - Apellido y Nombre: " + this.apellido + ", " + this.nombre + " - Tel: " + this.telefono;
	}

	public int getIdPasajero() {
		return this.idPasajero;
	}
}
