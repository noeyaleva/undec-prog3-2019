package dominio;

import java.time.LocalDate;

import dominio.exceptions.ExceptionApellidoMalFormado;
import dominio.exceptions.ExceptionCuilMalFormado;
import dominio.exceptions.ExceptionGeneral;
import dominio.exceptions.ExceptionIdMalFormado;
import dominio.exceptions.ExceptionNombreMalFormado;

public class Piloto {

	private int idPiloto;
	private String apellido;
	private String nombre;
	private String documento;
	private LocalDate fechaNacimiento;
	
	public Piloto(int pIdPiloto, String pApellido, String pNombre, String pDocumento, LocalDate pFechaNacimiento) throws ExceptionGeneral {
	
		if(pIdPiloto < 1) {
			throw new ExceptionIdMalFormado("Error en el Id.");
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
					if(pDocumento == "" || pDocumento == null) {
						throw new ExceptionCuilMalFormado("Error en el documento");
					}
					else {
						if(pFechaNacimiento == null) {
							throw new ExceptionGeneral("Error en la fecha");
						}
						else {
							this.idPiloto = pIdPiloto;
							this.apellido = pApellido.substring(0,1).toUpperCase() + pApellido.substring(1).toLowerCase();
							this.nombre = pNombre.substring(0,1).toUpperCase() + pNombre.substring(1).toLowerCase();
							this.documento = pDocumento;
							this.fechaNacimiento = pFechaNacimiento;
						}
					}
				}
			}
		}
		
	}

	@Override
	public String toString() {
		//ID: 1 - Apellido y Nombre: Juarez, Enrique - DNI: 12345678 - Fecha Nacimiento: 01/05/1990
		return "ID: " + this.idPiloto + " - Apellido y Nombre: " + this.apellido + ", " + this.nombre + " - DNI: " + this.documento + " - Fecha Nacimiento: " + formaFecha();
	}
	
	private String formaFecha() {
		String cadena = "";

		if(fechaNacimiento.getDayOfMonth() < 10) {
			cadena += "0"+ fechaNacimiento.getDayOfMonth() + "/";
		}
		else {
			cadena += fechaNacimiento.getDayOfMonth() + "/";
		}
		
		if(fechaNacimiento.getMonthValue() < 10) {
			cadena += "0" + fechaNacimiento.getMonthValue() + "/"; 
		}
		else {
			cadena += fechaNacimiento.getMonthValue() + "/";
		}
		
		cadena += fechaNacimiento.getYear();
		
		return cadena;
	}
	
	public String getApellido() {
		return this.apellido;
	}
	
	public int getIdPiloto() {
		return this.idPiloto;
	}
}
