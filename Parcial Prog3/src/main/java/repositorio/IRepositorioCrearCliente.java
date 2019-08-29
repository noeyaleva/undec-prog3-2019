package repositorio;

import excepciones.ClienteExisteException;
import modelo.Cliente;

public interface IRepositorioCrearCliente {

	boolean guardar(Cliente clienteNuevo);

	Cliente findByDNI(String string);

}
