package modelo;

import excepciones.VehiculoIncompletoException;

public class Vehiculo {

	private int codigo;
	private String marca;
	private String patente;
	private int modelo;
	
	public static Vehiculo factoryVehiculo(int codigo, String marca, String patente, int modelo) throws VehiculoIncompletoException {
		
		
			if(codigo <= 0) {
				throw new VehiculoIncompletoException();
			}
			
			if(marca == null) {
				throw new VehiculoIncompletoException();
			}
	
			if(patente == null) {
				throw new VehiculoIncompletoException();
			}
			
			if(modelo <= 0) {
				throw new VehiculoIncompletoException();
			}
			
		return new Vehiculo(codigo, marca, patente, modelo);
	}

	private Vehiculo(int codigo, String marca, String patente, int modelo) {
		this.codigo = codigo;
		this.marca = marca;
		this.patente = patente;
		this.modelo = modelo;
	}

	public String mostrarVehiculo() {
		//VW Golf modelo 2009 - Patente ABC123
		return this.marca + " modelo " + this.modelo + " - Patente " + this.patente;
	}
	
	
}
