package modelo;

import java.time.LocalDate;

import excepciones.ServiceIncompletoException;

public class Service {

	//1, elVehiculo, elCliente, LocalDate.of(2018, 10, 10),
	//"Cambio de Aceite y Filtro", 1500.00f
	private int id;
	private Vehiculo vehiculo;
	private Cliente cliente;
	private LocalDate fecha;
	private String detalle;
	private double precio;
	
	public static Service factoryService(int id, Vehiculo elVehiculo, Cliente elCliente, LocalDate of, String detalle,
			float precio) throws ServiceIncompletoException {
		
		if(elVehiculo == null) {
			throw new ServiceIncompletoException();
		}
		
		return new Service(id, elVehiculo, elCliente, of, detalle, precio);
	}

	private Service(int id, Vehiculo vehiculo, Cliente cliente, LocalDate fecha, String detalle, double precio) {
		super();
		this.id = id;
		this.vehiculo = vehiculo;
		this.cliente = cliente;
		this.fecha = fecha;
		this.detalle = detalle;
		this.precio = precio;
	}

	public String mostrarResumen() {
		// TODO Apéndice de método generado automáticamente
		//"Service Nro: 1\nCliente: Perez, Juan - 15152020\nVehiculo: VW Golf modelo 2009 - Patente ABC123\nTrabajo Realizado: Cambio de Aceite y Filtro"
		return "Service Nro: " + this.id + "\nCliente: " +this.cliente.toString() + "\nVehiculo: " + this.vehiculo.mostrarVehiculo() + "\nTrabajo Realizado: " + this.detalle;
	}
	
	
}
