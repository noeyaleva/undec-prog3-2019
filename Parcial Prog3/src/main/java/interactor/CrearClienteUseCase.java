package interactor;

import java.util.ArrayList;
import java.util.List;

import excepciones.ClienteExisteException;
import modelo.Cliente;
import repositorio.IRepositorioCrearCliente;

public class CrearClienteUseCase implements IRepositorioCrearCliente{

	private IRepositorioCrearCliente crearClienteGateway;
	private List<Cliente> misClientes = new ArrayList<Cliente>();
	
	public CrearClienteUseCase(IRepositorioCrearCliente crearClienteGateway) {
		this.crearClienteGateway = crearClienteGateway;
	}

	public boolean crearCliente(Cliente clienteNuevo) throws ClienteExisteException {

		if(!this.crearClienteGateway.guardar(clienteNuevo)) {
			throw new ClienteExisteException();
		}
		return this.crearClienteGateway.guardar(clienteNuevo);
	}

	@Override
	public boolean guardar(Cliente clienteNuevo){
		if(misClientes.contains(clienteNuevo)) {
			
			return false;
		}
		
		misClientes.add(clienteNuevo);
		return true;
	}

	@Override
	public Cliente findByDNI(String dni) {
		
		for (Cliente cliente : misClientes) {
			if(cliente.equals(dni)) {
				return cliente;
			}
		}
		
		return null;
	}

}
