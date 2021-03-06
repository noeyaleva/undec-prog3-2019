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
	
	public Avion(int aIdAvion, String aModelo, String aMatricula, List<Asiento> aListaAsientos) throws ExceptionIdMalFormado, ExceptionModeloMalFormado, ExceptionMatriculaMalFormado {
	
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

	public int getIdAvion() {
		return idAvion;
	}

	public void setIdAvion(int idAvion) {
		this.idAvion = idAvion;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public List<Asiento> getListaAsientos() {
		return listaAsientos;
	}

	public void setListaAsientos(List<Asiento> listaAsientos) {
		this.listaAsientos = listaAsientos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAvion;
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
		Avion other = (Avion) obj;
		if (idAvion != other.idAvion)
			return false;
		return true;
	}
	
	

}
