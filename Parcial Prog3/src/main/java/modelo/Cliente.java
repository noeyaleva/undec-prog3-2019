package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import excepciones.ClienteIncompletoException;

public class Cliente {
	//1,"Perez", "Juan","12345678",LocalDate.of(1990, 1, 1) , "Av. San Martin 123", "15152020"
	private int id;
	private String apellido;
	private String nombre;
	private String dni;
	private LocalDate fechaNacimiento;
	private String direccion;
	private String telefono;
	private List<Vehiculo> misVehiculos = new ArrayList<Vehiculo>();
	
	public static Cliente factoryCliente(int id, String apellido, String nombre, String dni, LocalDate fechaNacimiento,
			String direccion, String telefono) throws ClienteIncompletoException {
		if(dni == null) {
			throw new ClienteIncompletoException();
		}
		
		return new Cliente(id, apellido, nombre, dni, fechaNacimiento, direccion, telefono);
	}

	private Cliente(int id, String apellido, String nombre, String dni, LocalDate fechaNacimiento, String direccion,
			String telefono) {
		super();
		this.id = id;
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public void asignarVehiculo(Vehiculo elVehiculo) {
		
		this.misVehiculos.add(elVehiculo);
		
	}

	public List<Vehiculo> devolverVehiculos() {
		
		return this.misVehiculos;
	}

	@Override
	public String toString() {
		return apellido + ", " + nombre + " - " + telefono;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
		Cliente other = (Cliente) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}
	
	

}
