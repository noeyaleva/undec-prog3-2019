package dominio;

import java.util.List;

import dominio.exceptions.ExceptionIdMalFormado;
import dominio.exceptions.ExceptionMatriculaMalFormado;
import dominio.exceptions.ExceptionModeloMalFormado;

import java.util.ArrayList;

public class Avion {
	
	private int idAvion;
	private String modelo;
	private String matricula;
	private List<Asiento> listaAsientos;
	
	public Avion(int aIdAvion, String aModelo, String aMatricula, ArrayList<Asiento> aListaAsientos) throws ExceptionIdMalFormado, ExceptionModeloMalFormado, ExceptionMatriculaMalFormado {
	
		if(aIdAvion < 1) {
			throw new ExceptionIdMalFormado("Error en el Id.");
		}
		else {
			if(aModelo == "" || aModelo == null) {
				throw new ExceptionModeloMalFormado("Error en el modelo");
			}
			else {
				if(aMatricula == "" || aMatricula == null) {
					throw new ExceptionMatriculaMalFormado("Error en la matricula");
				}
				else {
					this.idAvion = aIdAvion;
					this.modelo = aModelo;
					this.matricula = aMatricula;
					this.listaAsientos = new ArrayList<Asiento>();
					this.listaAsientos = aListaAsientos;
				}
			}
		}
		
	}

	@Override
	public String toString() {
		//ID: 1 - Modelo: modelo - Matricula: matricula - Asientos: A1, A2
		return "ID: " + this.idAvion + " - Modelo: " + this.modelo + " - Matricula: " + this.matricula +" - Asientos: " + cantidadAsiento();
	}
	
	private String cantidadAsiento() {
		String cadena = "";
		for (Asiento asiento : listaAsientos) {
			cadena += asiento.getNumeroAsiento() + ", ";
			
		}
		return cadena.substring(0,cadena.length()-2);
	}
	

}
